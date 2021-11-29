package mazeGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Maze {

    private Node[] graph;
    private final int rowNum;
    private final int colNum;


    //constructor - fill the graph with unconnected nodes
    Maze(int m, int n){
        rowNum = m;
        colNum = n;
        this.graph = new Node[m*n];

        for(int i = 0; i < graph.length; i++)
            graph[i] = new Node(i);
    }

    //getters
    public Node getNode(int i){ return graph[i];}
    public Node[] getGraph(){return graph;}

    public ArrayList<int[]> getEdges(){

        ArrayList <int[]> edges = new ArrayList();
        //traverse the Node list and add all the possible pairing between nodes
        //node can only connect up down left and right;
        for(int i = 0; i < rowNum * colNum; i++){

            //check for right edge - case where node i isn't the rightmost node on the row
            if( i % colNum != colNum - 1)
                //right edge is possible
                edges.add(new int[] {i , i + 1});

            //check for 'down' edge - happened always unless i is in the lowest row
            if( i % rowNum != rowNum - 1)
                //'down' edge is possible
                edges.add(new int[] {i, i + colNum});
        }
        Collections.shuffle(edges);
        return edges;
    }

    /**
     * this function receives by ID two Nodes and connect them according to their position on the
     * maze matrix.since ID1 is always smaller we only check for 'right' and 'down' connections
     * @param ID1 - first node's ID - smaller then ID2
     * @param ID2 - second node's ID
     */
    public void connectNodes(int ID1, int ID2){

        if(ID2 % colNum == ID1 % colNum) {
            //this is a vertical connection
            graph[ID1].down = graph[ID2];
            graph[ID2].up = graph[ID1];
        }
        else{
            //this is a horizontal connection
            graph[ID1].right = graph[ID2];
            graph[ID2].left = graph[ID1];
        }

    }
    public static void main(String[] args) {

        Maze m = new Maze(4,5);
//        UnionFind makeMaze = new UnionFind(20 , m);


        for(int[]  edge:m.getEdges()){

            System.out.println("(" + edge[0] + ", " + edge[1] + ")");
        }
    }










}
