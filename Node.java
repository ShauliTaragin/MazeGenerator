package mazeGenerator;

public class Node {

    //this class represent a single node in the maze
    int ID;
    Node left, right, up, down;

    public Node(int id){
        left = right = up = down = null;
        ID = id;
    }

}
