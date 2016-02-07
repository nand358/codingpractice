package library.trees;

/**
 * Created by anatarajan on 11/1/15.
 */
public class NaiveIsBTaBST {

    public IntNode initializeAndReturnBST() {
        IntNode oneNode = new IntNode(1);
        IntNode sixNode = new IntNode(6);
        IntNode fourNode = new IntNode(4, oneNode, sixNode);

        IntNode nineNode = new IntNode(9);

        IntNode root = new IntNode(7, fourNode, nineNode);
        return root;
    }

    public IntNode initializeAndReturnNonBST() {
        IntNode oneNode = new IntNode(1);
        IntNode nineNode = new IntNode(9);
        IntNode twelveNode = new IntNode(12);

        IntNode eightNode = new IntNode(8, nineNode, twelveNode);

        IntNode root = new IntNode(5, oneNode, eightNode);
        return root;
    }

    public boolean isSubTreeLesser(IntNode root, int data) {
        if (root == null) return true;
        return root.d <= data && isSubTreeLesser(root.left, data) && isSubTreeLesser(root.right, data);
    }

    public boolean isSubTreeGreater(IntNode root, int data) {
        if (root == null) return true;
        return root.d > data && isSubTreeGreater(root.left, data) && isSubTreeGreater(root.right, data);
    }

    public boolean isBTABST(IntNode root) {

        if (root == null) return true;
        return isSubTreeLesser(root.left, root.d)
                && isSubTreeGreater(root.right, root.d)
                && isBTABST(root.left)
                && isBTABST(root.right);
    }

    public static void main(String[] args) {
        NaiveIsBTaBST checker = new NaiveIsBTaBST();
        IntNode root = checker.initializeAndReturnBST();
        System.out.println("Checking if BT is BST : Input is BST. Output should be : " + checker.isBTABST(root));

        root = checker.initializeAndReturnNonBST();
        System.out.println("Checking if BT is BST : Input is non-BST. Output should be : " + checker.isBTABST(root));
    }
}
