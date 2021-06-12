package LinkedList;

public class SinglyLinkedList<T> {
    public Node headNode;
    public int size;

    public SinglyLinkedList() {
        // headNode is used as a direct pointer (NOT MEANT TO HOLD data OR nextNode values)
        // to hold reference to first Node object in the list
        // so always do, headNode = newNode (not headNode.nextNode = newNode)
        headNode = null;
        size = 0;
    }

    public boolean isEmpty() {
        return this.headNode == null;
    }

    // O(1)
    public void insertAtHead(T data) {
        // Create a new node for new data
        Node newNode = new Node();
        newNode.data = data;

        // Link headNode to this newNode and make newNode's nextNode point to 
        // whatever headNode is pointing (null or Node object reference) at
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }

    // O(n)
    public void insertAtEnd(T data) {
        // Two cases
        if(isEmpty() == true) {
            insertAtHead(data);
        }
        //
        Node newNode = new Node();
        newNode.data = data;

        Node last = headNode;
        while(last.nextNode != null) {
            last = last.nextNode;
        }
        // Re-link
        newNode.nextNode = null;
        last.nextNode = newNode;
        size++;
    }

    public void insertAfter(T data, T previousData) {
        //
        if (isEmpty() == true) {
            return;
        }
        // Find the previousData
        Node temp = headNode;
        Node prevNode = null;
        while(temp.nextNode != null) {
            if (temp.data == previousData) {
                prevNode = temp;
                break;
            }
            temp = temp.nextNode;
        }
        // Not found, return
        if (prevNode == null) {
            System.out.println("Data not found in the list!");
            return;
        }
        // Found, Re-link
        Node newNode = new Node();
        newNode.data = data;

        temp = prevNode.nextNode;
        prevNode.nextNode = newNode;
        newNode.nextNode = temp;
        size++;
    }

    public void printList() {
        // Empty List
        if (isEmpty() == true) {
            System.out.println("List is Empty!");
            return;
        }
        // Not Empty
        System.out.print("List: ");
        Node tempNode = headNode;
        while(tempNode.nextNode != null) {
            System.out.print(tempNode.data.toString() + " -> ");
            tempNode = tempNode.nextNode;
        }
        System.out.print(tempNode.data.toString() + " -> null\n");
    }

    // Test
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

        oSLL.insertAfter(67, 12);
        oSLL.printList();

        oSLL.insertAfter(69, 178);
        oSLL.printList();
        System.out.println("Size: " + oSLL.size);
    }
}

