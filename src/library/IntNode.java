package library;

/**
 * Created by anatarajan on 11/1/15.
 */
public class IntNode {

    int d;
    IntNode left = null;
    IntNode right = null;

    public IntNode(int d) {
        this.d = d;
    }

    public IntNode(int d, IntNode left, IntNode right) {
        this.d = d;
        this.left = left;
        this.right = right;
    }

}
