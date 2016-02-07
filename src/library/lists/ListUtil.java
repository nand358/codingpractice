package library.lists;

/**
 * Created by anatarajan on 11/16/15.
 */
public class ListUtil {
    public static void printList(ListNode head) {
        ListNode printNode = head;
        while(printNode != null) {
            System.out.print(printNode.val() + "->");
            printNode = printNode.next();
        }
        System.out.print("Ø");
        System.out.println("\n-------------------");
    }
}
