package library.lists;

import java.util.Scanner;

/**
 * Created by anatarajan on 11/16/15.
 */
public class RemoveSortedListDuplicates {

    public ListNode removeDuplicates(ListNode head) {
        if(head == null || head.next() == null) return head;
        ListNode p = head;

        while(p != null && p.next() != null) {
            if(p.val() == p.next().val()) {
                p.setNext(p.next().next());
            } else {
                p = p.next();
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter total entries : ");
        int length = in.nextInt();
        System.out.printf("Enter a Node val : ");
        int val = in.nextInt();
        ListNode head = new ListNode(val);
        ListNode next = head;
        for(int i = 1; i < length; i++) {
            System.out.printf("Enter a Node val : ");
            val = in.nextInt();
            ListNode newNode = new ListNode(val);
            next.setNext(newNode);
            next = newNode;
        }

        ListUtil.printList(head);
        RemoveSortedListDuplicates duplicatesRemover = new RemoveSortedListDuplicates();
        head = duplicatesRemover.removeDuplicates(head);
        ListUtil.printList(head);
    }
}
