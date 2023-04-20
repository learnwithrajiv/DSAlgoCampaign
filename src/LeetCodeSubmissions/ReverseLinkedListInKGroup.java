package LeetCodeSubmissions;

public class ReverseLinkedListInKGroup {
    public static void main(String[] args) {

    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curNode = head, ptr = head;
        while (ptr != null) {
            int i = 1;
            while (i <= k && ptr != null) {
                ptr = ptr.next;
                i++;
            }
            if (i < k) break;
            reverse (curNode, ptr);
        }
        return curNode;
    }

    private static ListNode reverse (ListNode curNode, ListNode ptr) {
        ListNode prev = null;
        ListNode current = curNode;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        curNode = prev;
        return curNode;
    }
}
