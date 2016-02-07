package library.lists;

import java.util.Scanner;

/**
 * Created by anatarajan on 11/16/15.
 */
public class PartitionListAtValue {

    public ListNode partition(ListNode head, int val) {
        ListNode fakeLHead = new ListNode(-1);
        ListNode fakeGHead = new ListNode(-1);
        ListNode p = head;
        ListNode lesser = fakeLHead, greater = fakeGHead;
        while(p != null) {
            if(p.val() <= val) {
                lesser.setNext(new ListNode(p.val()));
                lesser = lesser.next();
            } else {
                greater.setNext(new ListNode(p.val()));
                greater = greater.next();
            }
            p = p.next();
        }

        lesser.setNext(fakeGHead.next());
        return fakeLHead.next();
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

        System.out.printf("Enter a value for split : ");
        int splitAt = in.nextInt();

        ListUtil.printList(head);
        PartitionListAtValue partitioner = new PartitionListAtValue();
        head = partitioner.partition(head, splitAt);
        ListUtil.printList(head);
    }

}
