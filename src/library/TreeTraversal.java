package library;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by anatarajan on 11/1/15.
 *
 * BFS is also known as Level-Order traversal.
 */

public class TreeTraversal {

    private static int levelOrderCounter;
    private static int preOrderCounter;
    private static int inOrderCounter;
    private static int postOrderCounter;

    public CharNode initializeAndReturnRoot() {
        CharNode A = new CharNode('A');
        CharNode C = new CharNode('C');
        CharNode B = new CharNode('B', A, C);
        CharNode E = new CharNode('E');

        CharNode D = new CharNode('D', B, E);

        CharNode H = new CharNode('H');
        CharNode I = new CharNode('I', H, null);
        CharNode G = new CharNode('G', null, I);

        CharNode K = new CharNode('K');
        CharNode J = new CharNode('J', G, K);

        CharNode F = new CharNode('F', D, J);
        return F;
    }

    public void levelOrder(final CharNode root) {

        Queue<CharNode> Q = new ArrayDeque<CharNode>();

        if(root == null) {
            System.out.println("Root is null.");
            return;
        }

        Q.add(root);

        while(!Q.isEmpty()) {
            CharNode current = Q.peek();
            levelOrderCounter++;
            System.out.print(current.d + ", ");
            if(current.left != null) Q.add(current.left);
            if(current.right != null) Q.add(current.right);
            Q.remove();
        }
    }

    public void preOrder(CharNode root) {
        if(root == null) return;

        System.out.print(root.d + ", ");
        preOrderCounter++;
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(CharNode root) {
        if(root == null) return;
        inOrderCounter++;
        inOrder(root.left);
        System.out.print(root.d + ", ");
        inOrder(root.right);
    }

    public void postOrder(CharNode root) {
        if(root == null) return;
        postOrderCounter++;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.d + ", ");
    }

    public static void main(String[] args) {
        // Create tree and call levelOrder method on TreeTraversal class.

        // BFS
        System.out.println("LEVEL-ORDER TREE TRAVERSAL....");
        TreeTraversal treeTraversal = new TreeTraversal();
        CharNode root = treeTraversal.initializeAndReturnRoot();
        treeTraversal.levelOrder(root);
        System.out.println("LEVEL-ORDER COUNT : " + levelOrderCounter);
        System.out.println();

        System.out.println("PRE-ORDER TREE TRAVERSAL....");
        treeTraversal.preOrder(root);
        System.out.println("PRE-ORDER COUNT : " + preOrderCounter);
        System.out.println();
        System.out.println("IN-ORDER TREE TRAVERSAL....");
        treeTraversal.inOrder(root);
        System.out.println("IN-ORDER COUNT : " + inOrderCounter);
        System.out.println();
        System.out.println("POST-ORDER TREE TRAVERSAL....");
        treeTraversal.postOrder(root);
        System.out.println("POST-ORDER COUNT : " + postOrderCounter);
        System.out.println();
    }


}


