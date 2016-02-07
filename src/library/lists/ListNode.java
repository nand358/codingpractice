package library.lists;

/**
 * Created by anatarajan on 11/16/15.
 */
public class ListNode {

    private int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int val() {
        return this.val;
    }

    public ListNode next() {
        return this.next;
    }
}
