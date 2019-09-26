package List.LinkedList;

public class LinkedListDriver {
    public static void main (String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        System.out.println("List before: ");
        LinkedListOperations.displayList(root);
        System.out.println("\nList after: ");
        LinkedListOperations.reverseList(root);


    }
}