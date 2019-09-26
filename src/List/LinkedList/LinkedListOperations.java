package List.LinkedList;

public class LinkedListOperations {
    public static void displayList (Node root) {
        Node node = root;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void reverseList (Node root) {
        Node current, prev, next;
        prev = next = null;
        current = root;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        root = prev;
        displayList(root);
    }
}
