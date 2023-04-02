package LeetCodeSubmissions;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];

        ListNode list02 = new ListNode(5, null);
        ListNode list01 = new ListNode(4, list02);
        ListNode list00 = new ListNode(1, list01);

        lists[0] = list00;

        ListNode list12 = new ListNode(4, null);
        ListNode list11 = new ListNode(3, list12);
        ListNode list10 = new ListNode(1, list11);

        lists[1] = list10;

        ListNode list21 = new ListNode(6, null);
        ListNode list20 = new ListNode(2, list21);

        lists[2] = list20;

        ListNode result = mergeKLists(lists);
        System.out.println(result);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return mergeKListsHelper(lists, 0, lists.length-1);
    }

    private static ListNode mergeKListsHelper (ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];

        if (start+1 == end) return merge(lists[start], lists[end]);

        int mid = start + (end-start) / 2;

        ListNode left = mergeKListsHelper (lists, start, mid);
        ListNode right = mergeKListsHelper (lists, mid + 1, end);

        return merge (left, right);
    }

    private static ListNode merge (ListNode left, ListNode right) {
        ListNode retVal = new ListNode(0);
        ListNode currentPointer = retVal;

        while (null != left && null != right) {
            if (left.val < right.val) {
                currentPointer.next = left;
                left = left.next;
            } else {
                currentPointer.next = right;
                right = right.next;
            }
            currentPointer = currentPointer.next;
        }

        currentPointer.next = (null != left) ? left : right;

        return retVal.next;
    }
}