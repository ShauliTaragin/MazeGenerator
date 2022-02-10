import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Maze {

    private Node[] graph;
    private final int rowNum;
    private final int colNum;


    //constructor - fill the graph with unconnected nodes
    Maze(int m, int n) {
        rowNum = m;
        colNum = n;
        this.graph = new Node[m * n];

        for (int i = 0; i < graph.length; i++)
            graph[i] = new Node(i);
    }

    //getters
    public Node getNode(int i) {
        return graph[i];
    }

    public Node[] getGraph() {
        return graph;
    }

    public ArrayList<int[]> getEdges() {

        ArrayList<int[]> edges = new ArrayList();
        //traverse the Node list and add all the possible pairing between nodes
        //node can only connect up down left and right;
        for (int i = 0; i < rowNum * colNum; i++) {

            //check for right edge - case where node i isn't the rightmost node on the row
            if (i % colNum != colNum - 1)
                //right edge is possible
                edges.add(new int[]{i, i + 1});

            //check for 'down' edge - happened always unless i is in the lowest row

            if (i / colNum != rowNum - 1)
                //'down' edge is possible
                edges.add(new int[]{i, i + colNum});
        }
        Collections.shuffle(edges);
        return edges;
    }

    /**
     * this function receives by ID two Nodes and connect them according to their position on the
     * maze matrix.since ID1 is always smaller we only check for 'right' and 'down' connections
     *
     * @param ID1 - first node's ID - smaller then ID2
     * @param ID2 - second node's ID
     */
    public void connectNodes(int ID1, int ID2) {

        if (ID2 % colNum == ID1 % colNum) {
            //this is a vertical connection
            graph[ID1].down = graph[ID2];
            graph[ID2].up = graph[ID1];
        } else {
            //this is a horizontal connection
            graph[ID1].right = graph[ID2];
            graph[ID2].left = graph[ID1];
        }

    }

    public static void main(String[] args) {

        if(args.length < 2){
            System.out.println("Not enough arguments");
            return;
        }
        int m, n;
        try {
            m = Integer.parseInt(args[0]);
            n = Integer.parseInt(args[1]);

        }
        catch (Exception e){
            System.out.println("Please insert integers only");
            return;
        }
        Maze mz = new Maze(m, n);

        UnionFind makeMaze = new UnionFind(m * n, mz);

        int[][] mazeMat = new int[2 * m + 1][2 * n + 1];

        //paint the mat with black
        for (int[] i : mazeMat)
            Arrays.fill(i, 1);

        //paint the nodes with yellow
        int c = 0, r = 0;
        for (int id = 0; id < mz.graph.length; id++) {
            r = 1 + (id / mz.colNum) * 2;
            c = 1 + (id % mz.colNum) * 2;
            mazeMat[r][c] = 0;

            if (mz.getNode(id).right != null)
                mazeMat[r][c + 1] = 0;

            if (mz.getNode(id).down != null)
                mazeMat[r + 1][c] = 0;

        }

        //mark the entrance and exit
        mazeMat[1][1] = 2;
        mazeMat[mazeMat.length -2][ mazeMat[0].length - 1] = 2;


        DrawMaze d = new DrawMaze(mazeMat);

    }
}



