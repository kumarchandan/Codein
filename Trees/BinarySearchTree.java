package Trees;

public class BinarySearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Insert - Iterative approach
    // Runtime: O(h), h: height of tree, If tree is skewed, worst case O(n)
    public boolean insert(int value) {

        // If tree is empty, initialize root
        if (isEmpty()) {
            root = new Node(value);
            return true;
        }

        // Traverse: Start from root
        Node currentNode = root;

        while (currentNode != null) {

            Node leftChild = currentNode.getLeftChild();
            Node rightChild = currentNode.getRightChild();

            if (value < currentNode.getData()) {
                if (leftChild == null) {
                    leftChild = new Node(value);
                    currentNode.setLeftChild(leftChild);
                    return true;
                }
                currentNode = leftChild;
            } else {
                if (rightChild == null) {
                    rightChild = new Node(value);
                    currentNode.setRightChild(rightChild);
                    return true;
                }
                currentNode = rightChild;
            }
        }

        return false;
    }

    // Insert - Recursive approach
    public boolean insert2(int value) {
        root = insertRecursive(this.root, value);
        return true;
    }

    // Runtime: O(h), h: height of tree, If tree is skewed, worst case O(n)
    public Node insertRecursive(Node currentNode, int value) {
        // Base case
        if (currentNode == null) {
            return new Node(value);
        }
        // Recursive case
        if (value < currentNode.getData()) {
            // Iterate left sub-tree
            // When finally reached to a leftmost node with null value, Base case will create new Node obj and return
            // Set that value as leftChild of currentNode
            currentNode.setLeftChild(insertRecursive(currentNode.getLeftChild(), value));
        } else if (value > currentNode.getData()) {
            // Iterate right sub-tree
            // When finally reached to a rightmost node with null value, Base case will create new Node obj and return
            // Set that value as rightChild of currentNode
            currentNode.setRightChild(insertRecursive(currentNode.getRightChild(), value));
        } else {
            // Value already exists
            return currentNode;
        }
        return currentNode;
    }

    // Search - Iterative
    // Runtime - O(log n) on average, in a balanced tree, Skewed tree - O(n)
    public Node search(int value) {
        
        if (isEmpty()) {
            return null;
        }

        Node currentNode = root;

        while (currentNode != null) {
            if (value == currentNode.getData()) {
                return currentNode;
            }

            if (value < currentNode.getData()) {
                currentNode = currentNode.getLeftChild();
            } else if (value > currentNode.getData()) {
                currentNode = currentNode.getRightChild();
            }
        }
        System.out.println("Node not found!");
        return null;
    }

    // Search - Recursive
    // Runtime - O(log n) on average, in a balanced tree, Skewed tree - O(n)
    public Node search2(int value) {
        if (isEmpty()) {
            return null;
        }
        return searchRecursive(this.root, value);
    }

    public Node searchRecursive(Node currentNode, int value) {
        // Base case
        // If currentNode is null or value is found, return node
        if (currentNode == null || currentNode.getData() == value) {
            return currentNode;
        }

        // Recursive case
        // If value is less than node's data, look into left subtree
        if (value < currentNode.getData()) {
            return searchRecursive(currentNode.getLeftChild(), value);
        } else { // If value is greater than node's data, look into right subtree
            return searchRecursive(currentNode.getRightChild(), value);
        }
    }

    public void printTree(Node current) {
        if (current == null) {
            return;
        }
        System.out.print(current.getData() + ", ");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());
    }

    public static void main(String[] args) {
        BinarySearchTree bsT = new BinarySearchTree();
        bsT.insert(6);
		bsT.insert(4);
		bsT.insert(9);
		bsT.insert(5);
		bsT.insert(2);
		bsT.insert(8);
		bsT.insert(12);
		bsT.insert(10);
		bsT.insert(14);

        bsT.printTree(bsT.getRoot());
        System.out.println("Call recursive BST insertion: \n");

        BinarySearchTree bsT2 = new BinarySearchTree();
        bsT2.insert2(6);
		bsT2.insert2(4);
		bsT2.insert2(9);
		bsT2.insert2(5);
		bsT2.insert2(2);
		bsT2.insert2(8);
		bsT2.insert2(12);
		bsT2.insert2(10);
		bsT2.insert2(14);

        bsT2.printTree(bsT2.getRoot());

        // Search Iterative
        Node temp = bsT.search(5);
		if (temp != null) {
			System.out.println("\n" + temp.getData() + " found in Tree !");
		}
		temp = bsT.search(51);
		if (temp != null) {
			System.out.println("\n" + temp.getData() + " found in Tree !");
		}

        // Search Recursive
        Node temp2 = bsT.search2(5);
		if (temp2 != null) {
			System.out.println("\n" + temp2.getData() + " found in Tree (Recur) !");
		} else {
            System.out.println("\n Not found in Tree !");
        }
		temp2 = bsT.search2(51);
		if (temp2 != null) {
			System.out.println("\n" + temp2.getData() + " found in Tree !");
		} else {
            System.out.println("\n Not found in Tree ! (Recur)");
        }
    }

}
