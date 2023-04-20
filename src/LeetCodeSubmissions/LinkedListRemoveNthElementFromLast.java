package LeetCodeSubmissions;

public class LinkedListRemoveNthElementFromLast {
    public static void main(String[] args) {
        ListNode node04 = new ListNode(5, null);
        ListNode node03 = new ListNode(4, node04);
        ListNode node02 = new ListNode(3, node03);
        ListNode node01 = new ListNode(2, node02);
        ListNode head = new ListNode(1, node01);

        display( removeNthFromEnd(head, 4) );
    }

    private static void display (ListNode head) {
        ListNode temp = head;
        while (null != temp) {
            System.out.print( temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr1 = head, ptr2 = head;
        for (int i = 0; i < n; i++) {
            ptr2 = ptr2.next;
        }
        if (null == ptr2) {
            return head.next;
        }
        while (null != ptr2.next) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        ptr1.next = ptr1.next.next;
        return head;
    }
}
