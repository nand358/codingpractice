package library.trees;

/**
 * Created by anatarajan on 11/1/15.
 */
public class EfficientIsBTaBST {

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

    public boolean checkBTIfItIsABST(IntNode root, int minValue, int maxValue) {
        if(root == null) return true;

        return (root.d > minValue && root.d < maxValue)
                && checkBTIfItIsABST(root.left, minValue, root.d)
                && checkBTIfItIsABST(root.right, root.d, maxValue);
    }

    public boolean isBTABST(IntNode root) {
        return checkBTIfItIsABST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    public static void main(String[] args) {
        EfficientIsBTaBST checker = new EfficientIsBTaBST();
        IntNode root = checker.initializeAndReturnBST();
        System.out.println("Checking if BT is BST : Input is BST. Output should be : " + checker.isBTABST(root));

        root = checker.initializeAndReturnNonBST();
        System.out.println("Checking if BT is BST : Input is non-BST. Output should be : " + checker.isBTABST(root));

    }
}
