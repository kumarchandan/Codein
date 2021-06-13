package LinkedList;

public class ReverseSinglyLinkedList {
    public static <T> void reverse(SinglyLinkedList<T> sll) {
        SinglyLinkedList<T>.Node current = sll.headNode;
        SinglyLinkedList<T>.Node next = null;
        SinglyLinkedList<T>.Node previous = null;

        while (current != null) {
            next = current.nextNode;
            current.nextNode = previous;
            previous = current;
            current = next;
        }

        // Link headNode with the new first element
        sll.headNode = previous;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> oSLL = new SinglyLinkedList<Integer>();
        oSLL.printList();

        for (int i = 1; i < 4; i++) {
            oSLL.insertAtHead(i);
            oSLL.printList();
        }

        for (int j = 12; j < 15; j++) {
            oSLL.insertAtEnd(j);
            oSLL.printList();
        }

        oSLL.printList();
        System.out.println("After reversal");
        ReverseSinglyLinkedList.reverse(oSLL);
        oSLL.printList();
    }
}
