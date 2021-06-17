package Trees;

/**
 * Find Nodes at "k" Distance from the Root
 * Given the root to a Binary Search Tree and a value "k", 
 * write a function to find the nodes at "k" distance from the root.
 * Input:
 bst = {
    6 -> 4,9
    4 -> 2,5
    9 -> 8,12
    12 -> 10,14
}
where parent -> leftChild, rightChild
k = 2

Output: 2,5,8,12
 */

/**
 * Runtime: O(n) Traverses each subtree and all elements of the tree
 */
public class FindNodesAtKDistanceBST {
    
    public static String findNodesAtK(Node root, int k) {
        StringBuilder result = new StringBuilder();
        result = findNodesRecursive(root, k, result);
        return result.toString();
    }

    public static StringBuilder findNodesRecursive(Node root, int k, StringBuilder result) {
        if (root == null) {
            return null;
        }
        if (k == 0) { // Reached to k distance, collect the values from the nodes
            result.append(root.getData() + ",");
        } else {
            // Keep decreasing k and Traverse left and right subtree until reaches to 0
            findNodesRecursive(root.getLeftChild(), k - 1, result);
            findNodesRecursive(root.getRightChild(), k - 1, result);
        }
        return result;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(6);
        bst.insert(4);
        bst.insert(9);
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);
        bst.insert(12);

        System.out.println(FindNodesAtKDistanceBST.findNodesAtK(bst.getRoot(), 2));
    }
}
