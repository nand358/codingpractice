package library.lists;

import java.util.Scanner;

/**
 * Created by anatarajan on 11/16/15.
 */
public class ReverseList {

    public ListNode reverse(ListNode head) {
        if(head == null || head.next() == null) return head;
        ListNode second = head.next();
        head.setNext(null);
        ListNode rest = reverse(second);
        second.setNext(head);

        return rest;
    }

    public ListNode iterativeReverse(ListNode head) {
        if(head == null || head.next() == null) return head;
        ListNode p1 = head, p2 = head.next();
        head.setNext(null);
        while(p1 != null && p2 != null) {
            ListNode temp = p2.next(); p2.setNext(p1); p1 = p2;
            if(temp != null)    p2 = temp;
            else                break;
        }
        return p2;
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

        System.out.printf("Enter 0 for Recursive or 1 for Iterative ? ");
        int procedure = in.nextInt();

        ReverseList reverser = new ReverseList();
        if(procedure == 0) {
            head = reverser.reverse(head);
        } else if(procedure == 1) {
            head = reverser.iterativeReverse(head);
        }

        ListUtil.printList(head);
    }

    public static void printList(ListNode head) {

    }
}
