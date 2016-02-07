package library.trees;

/**
 * Created by anatarajan on 11/1/15.
 */
public class IntNode {

    int d;
    IntNode left = null;
    IntNode right = null;
    IntNode parent = null;

    public IntNode(int d) {
        this.d = d;
    }

    public IntNode(int d, IntNode left, IntNode right) {
        this.d = d;
        this.left = left;
        this.right = right;
    }

    public IntNode(int d, IntNode left, IntNode right, IntNode parent) {
        this(d, left, right);
        this.parent = parent;
    }

}
