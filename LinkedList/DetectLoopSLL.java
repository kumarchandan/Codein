package LinkedList;

/**
 * Using Floyd Cycle Detection Algorithm
 * 
 * We start traversing the LinkedList using two pointers called slow and fast until all of them point to null
 * Move slow by one and fast by two. 
 * If these pointers meet at the same node, then there is a loop.
 * If these pointers do not meet, then LinkedList doesn’t have a loop.
 * 
 * Runtime: Constant O(n)
 * Memory: O(1) : Auxiliary space taken by slow and fast pointers
 */
public class DetectLoopSLL {
    public static <T> boolean detectLoop(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node slow = list.headNode;
        SinglyLinkedList<T>.Node fast = list.headNode;

        while (slow != null && fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.insertAtHead(10);
        sll.insertAtHead(20);
        sll.insertAtHead(30);

        sll.printList();
        System.out.println("Is there a loop? " + DetectLoopSLL.detectLoop(sll));
        System.out.println("Inserting a loop..");
        sll.headNode.nextNode.nextNode = sll.headNode; // headNode (30) -> 20 -> headNode(30) -> 20 ...
        System.out.println("Is there a loop? " + DetectLoopSLL.detectLoop(sll));
    }
}
