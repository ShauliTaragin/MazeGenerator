package mazeGenerator;

import java.util.ArrayList;

public class UnionFind {
    int[] parents;
    int[] Size;
    Maze maze;

    /**
     * Our UnionFind constructor. we create our union find from:
     * @param size -> the size of our nodes list
     * @param maze ->
     */
    public UnionFind(int size , Maze maze){
        this.maze = maze;
        this.Size= new int[size];
        this.parents = new int[size];
        for (int i = 0; i <size; i++) {
            this.parents[i]=i; //create each element in the parents array to be its own parent.
            this.Size[i]=1;
        }
        connect_maze_graph(maze.getEdges());
    }
    public int find(int a){
        if (parents[a]!=a)
            parents[a]=find(parents[a]);
        return parents[a];
    }

    /**
     * @param ind1 - receive index of a node from our graph(node list)
     * @param ind2 - receive index of a node we wish to compare to the first node we just received
     * if these nodes are not connected(a.k they dont have the same parent) ,  then we create an edge
     *           between them and union them.
     */
    public void union(int ind1, int ind2) {
        int a = find(ind1);
        int b = find(ind2);
        if(a!=b){//only if they are not part of the same component set then do we union them.
            this.maze.connectNodes(ind1,ind2);//connect the 2 nodes by edge then union.
            if(Size[a]<=Size[b]) {
                parents[a] = b;
                Size[b]=Size[a]+Size[b];
            }
            else{
                parents[b]=a;
                Size[a]=Size[a]+Size[b];
            }
        }
    }

    /**
     * This function will connect the nodes by edges according to union find
     * @param edges - we receive an already randomized list of edges and we union each edge
     *              (e.g each 2 nodes that connect an edge)
     */
    public void connect_maze_graph(ArrayList<int[]> edges){
        for (int i = 0; i <edges.size() ; i++) {
            union(edges.get(i)[0] , edges.get(i)[1]);
        }
    }
}
