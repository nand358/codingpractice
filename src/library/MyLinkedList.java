package library;

/**
 * Created by anatarajan on 10/25/15.
 */
public class MyLinkedList {
    //TODO: Incomplete.
    class Node {
        Node next = null;
        int data;

        public Node(int d) { data = d; }

        void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) { n = n.next; } n.next = end;
        }
    }

    Node deleteNode(Node head, int d) {
        Node n = head;

        if(n.data == d) {
            return head.next;
        }

        while(n.next != null) {
            if(n.next.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }

    private static String removeDuplicates(char[] input) {

        for(int i = 1; i < input.length; i++) {
            for(int j = 0; j < i; j++) {
                if (input[j] == input[i]) {
                    input[i] = '\0';
                }
            }
        }

        return new String(input);
    }



    Node removeDuplicates(Node head) {

        Node n = head;
        Node temp = head;
        if(head == null) return head;
        if(n.next == null) return head;

        while(n.next != null) {
            Node currentNode = n.next;
            int data = currentNode.data;

            while(temp != null && temp.next != currentNode) {
                if(temp.data == currentNode.data) {
                    head = deleteNode(head, currentNode.data);
                }
                temp = temp.next;
            }


        }
        return head;
    }
}
