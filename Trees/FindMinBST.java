package Trees;

/**
 * Find the Minimum Value in a Binary Search Tree
 * 
 * Traverse the left sub-tree and go to the leftmost value
 * 
 */
public class FindMinBST {

    /**
     * Runtime: O(h) : where h is height of the tree
     *          O(n) : worst case - skewed tree
     */
    public static int findMin(Node root) {
        Node parentNode = null;

        // parentNode will hold the leftmost node (min value) when loop gets over
		while (root != null) {
            parentNode = root;
            root = root.getLeftChild();
		}
		return parentNode.getData();
	}

    /**
     * Runtime: O(h) : where h is height of the tree
     *          O(n) : worst case - skewed tree
     */
    public static int findMin2(Node root) {
        if (root == null) {
            return -1;
        } else if (root.getLeftChild() == null) {
            return root.getData(); // Leftmost node
        } else { // Recursive case
            return findMin2(root.getLeftChild());
        }
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

        System.out.println(findMin(bsT.getRoot()));

        System.out.println(findMin2(bsT.getRoot()));
    }
}
