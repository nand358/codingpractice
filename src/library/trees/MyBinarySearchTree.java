package library.trees;

/**
 * Created by anatarajan on 11/9/15.
 */
public class MyBinarySearchTree {

    public IntNode initializeAndReturnRoot() {
        IntNode node2 = new IntNode(2);
        IntNode node3 = new IntNode(3);
        IntNode node4 = new IntNode(4);
        IntNode node6 = new IntNode(6);
        IntNode node7 = new IntNode(7);
        IntNode node9 = new IntNode(9);
        IntNode node13 = new IntNode(13);
        IntNode node15 = new IntNode(15);
        IntNode node17 = new IntNode(17);
        IntNode node18 = new IntNode(18);
        IntNode node20 = new IntNode(20);

        // Tree-setup - could have done this better.
        node2.parent = node3; node4.parent = node3;
        node3.left = node2; node3.right = node4; node3.parent = node6;
        node13.left = node9; node9.parent = node13; node13.parent = node7;
        node7.right = node13; node7.parent = node6;
        node6.left = node3; node6.right = node7; node6.parent = node15;
        node17.parent = node18; node20.parent = node18;
        node18.left = node17; node18.right = node20; node18.parent = node15;
        node15.left = node6; node15.right = node18;
        return node15;
    }

    public IntNode recursiveTreeSearch(IntNode x, int k) {
        if ((x == null) || k == x.d) return x;
        else if(k < x.d) {
            return recursiveTreeSearch(x.left, k);
        } else {
            return recursiveTreeSearch(x.right, k);
        }
    }

    public IntNode iterativeSearch(IntNode x, int k) {
        while(x != null && k != x.d) {
            if(k < x.d) x = x.left;
            else x = x.right;
        }
        return x;
    }

    public IntNode treeMinimum(IntNode x) {
        while(x.left != null) {
            x = x.left;
        }
        return x;
    }

    public IntNode treeMaximum(IntNode x) {
        while(x.right != null) {
            x = x.right;
        }
        return x;
    }

    public IntNode inOrderSuccessor(IntNode x) {
        if(x.right != null) {
            return treeMinimum(x.right);
        }
        IntNode y = x.parent;
        while(y != null && y.right == x) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    public IntNode inOrderPredecessor(IntNode x) {
        if(x.left != null) {
            return treeMaximum(x.left);
        }
        IntNode y = x.parent;
        while(y != null && y.left == x) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    // In-Order Walk of Tree from root Node.
    public void inOrder(IntNode root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.d + ", ");
        inOrder(root.right);
    }

    /*
        Straight forward case -
        Keep checking data at each node on while one is greater and
        Append newNode at left or right depending on that.
      */

    public IntNode insert(IntNode root, IntNode newNode) {
        IntNode x = root;
        IntNode y = null;
        while(x != null) {
            y = x;
            if(newNode.d < x.d) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        newNode.parent = y;
        if(y == null) {
            root = newNode;
        } else {
            if(newNode.d > y.d) {
                y.right = newNode;
                newNode.parent = y;
            } else {
                y.left = newNode;
                newNode.parent = y;
            }
        }
        return root;
    }

    /**
     * 3 Cases

     1. If  tobedeletedNode has no children, then we simply remove it by modifying
     its parent to re- place  ́ with NIL as its child.
     2. If tobedeletedNode has just one child, then we elevate that child to take  tobedeletedNode’s position in the tree by
     modifying  ́’s parent to replace  ́ by  ́’s child.
     3. If  tobedeletedNode has two children, then we find  tobedeletedNode's successor
     y—which must be in  ́’s right subtree—and have y take  ́’s position in the tree.
     The rest of  ́’s original right subtree becomes y’s new right subtree, and  ́’s left subtree
     becomes y’s new left subtree.

     This case is the tricky one because, as we shall see, it matters whether y is  ́’s right child.

     */
    public IntNode delete(IntNode root, IntNode nodeZ) {

        //case 1:
        if(nodeZ.right == null || nodeZ.left == null) {
            // case a:
            if(nodeZ.parent.left == nodeZ) {
                nodeZ.parent.left = null;
            } // case b:
            else if(nodeZ.parent.right == nodeZ) {
                nodeZ.parent.right = null;
            }
        } // case 3:
        else if(nodeZ.left != null && nodeZ.right != null) {
           // find tree minimum and
            IntNode temp = nodeZ.right;
            while(temp.left != null) {
                temp = temp.left;
            }
            if(temp.right != null) {
                // 2 cases:

                temp.parent.left = temp.right;
                temp.right.parent = temp.parent;
            }
            // now replace node to be deleted with temp
            nodeZ.d = temp.d;

        } // case 2:
        else if(nodeZ.left != null || nodeZ.right != null) {
            IntNode child = nodeZ.left == null? nodeZ.right : nodeZ.left;
            if(nodeZ.parent.left == nodeZ) {
                nodeZ.parent.left = child;
            } else if(nodeZ.parent.right == nodeZ) {
                nodeZ.parent.right = child;
            }
        }


        return root;
    }

    public static void main(String[] args) {
        MyBinarySearchTree bst = new MyBinarySearchTree();
        IntNode root = bst.initializeAndReturnRoot();
        System.out.println("TreeMinimum is " + bst.treeMinimum(root).d);

        root = bst.initializeAndReturnRoot();
        System.out.println("TreeMaximum is " + bst.treeMaximum(root).d);

        root = bst.initializeAndReturnRoot();
        IntNode node13 = root.left.right.right;
        System.out.println("InOrderSuccessor of " + node13.d + " is " + bst.inOrderSuccessor(node13).d);

        root = bst.initializeAndReturnRoot();
        IntNode node17 = root.right.left;
        System.out.println("InOrderSuccessor of " + node17.d + " is " + bst.inOrderSuccessor(node17).d);

        root = bst.initializeAndReturnRoot();
        IntNode node6 = root.left;
        System.out.println("InOrderPredecessor of " + node6.d + " is " + bst.inOrderPredecessor(node6).d);


        root = bst.initializeAndReturnRoot();
        node17 = root.right.left;
        System.out.println("InOrderPredecessor of " + node17.d + " is " + bst.inOrderPredecessor(node17).d);

        root = bst.initializeAndReturnRoot();
        IntNode tree = bst.insert(root, new IntNode(14));
    }
}
