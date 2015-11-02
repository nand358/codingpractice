package library;

/**
 * Created by anatarajan on 10/27/15.
 */
public class ReverseList {

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

    public Node reverseList(Node head) {

        if(head == null || head.next == null) return head;

        Node p1 = head;
        Node p2 = head.next;

        head.next = null;


        while(p1 != null && p2 != null) {
            Node t = p2.next;
            p2.next = p1;
            p1 = p2;
            if(t == null) {
                break;
            } else {
                p2 = t;
            }
        }

        return p2;

    }



}
