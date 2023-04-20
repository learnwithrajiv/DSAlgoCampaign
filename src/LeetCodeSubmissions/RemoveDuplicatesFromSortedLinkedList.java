package LeetCodeSubmissions;

public class RemoveDuplicatesFromSortedLinkedList {
    public static void main(String[] args) {
        ListNode node3 = new ListNode(2, null);
        ListNode node2 = new ListNode(1, node3);
        ListNode head = new ListNode(1, node2);
        display(deleteDuplicates(head));
    }

    private static void display (ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode slowPtr = head, fastPtr = head;
        while (null != fastPtr) {
            if (null != fastPtr.next && fastPtr.val == fastPtr.next.val) {
                fastPtr = fastPtr.next;
            } else {
                fastPtr = fastPtr.next;
                slowPtr.next = fastPtr;
                slowPtr = slowPtr.next;
            }
        }
        return head;
    }
}
