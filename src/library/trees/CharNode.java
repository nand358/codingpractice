package library.trees;

/**
 * Created by anatarajan on 11/1/15.
 */
public class CharNode {
    char d;
    CharNode left = null;
    CharNode right = null;

    protected CharNode(char d) {
        this.d = d;
    }

    protected CharNode(char d, CharNode left, CharNode right) {
        this.d = d;
        this.left = left;
        this.right = right;
    }

    public void printData() {
        System.out.print(this.d + ", ");
    }
}
