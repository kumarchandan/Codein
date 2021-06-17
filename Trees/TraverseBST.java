package Trees;

/**
 * Runtime: O(n) : Iterative or Recursive for all traversals, have to visit all nodes
 */
public class TraverseBST {
    
    
    public static void preOrderTraversal(Node root) { // Root-Left-Right
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + ", ");
        preOrderTraversal(root.getLeftChild());
        preOrderTraversal(root.getRightChild());
    }

    public static void inOrderTraversal(Node root) { // Left-Root-Right
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeftChild());
        System.out.print(root.getData() + ", ");
        inOrderTraversal(root.getRightChild());
    }

    public static void postOrderTraversal(Node root) { // Left-Right-Root
        if (root == null) {
            return;
        }
        postOrderTraversal(root.getLeftChild());
        postOrderTraversal(root.getRightChild());
        System.out.print(root.getData() + ", ");
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(6);
		bst.insert(4);
		bst.insert(2);
		bst.insert(5);
		bst.insert(9);
		bst.insert(8);
		bst.insert(12);

        System.out.println("\nPreorder Traversal: ");
        TraverseBST.preOrderTraversal(bst.getRoot());
        System.out.println("\nInorder Traversal: ");
        TraverseBST.inOrderTraversal(bst.getRoot());
        System.out.println("\nPostorder Traversal: ");
        TraverseBST.postOrderTraversal(bst.getRoot());
    }
}
