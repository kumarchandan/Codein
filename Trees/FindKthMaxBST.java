package Trees;

/**
 * Given the root to a binary search tree and a number "k".
 * Write a function to find the kth maximum value in that tree.
 */
/**
 Input:
 bst = {
    6 -> 4, 9
    4 -> 2, 5
    9 -> 8, 12
    12 -> 10, 14
}
where parent -> leftChild,rightChild
k = 3

Output: 10
 */
/**
 * TRICK: In-order traversal visits node in an ascending order
 */
public class FindKthMaxBST {

    public static int findKthMax(Node root, int k) {
        // Perform In-Order traversal to get sorted array (ascending order)
        // Return value at index (length - k)
        StringBuilder result = new StringBuilder(); // StringBuilder is mutable
        result = inOrderTraversal(root, result);

        // Sorted values from tree in ascending order
        String[] arr = result.toString().split(","); // Split String by , into an String array

        // Return the kth from last
        if (arr.length - k >= 0) {
            return Integer.parseInt(arr[arr.length - k]);
        }
        return -1;
    }

    public static StringBuilder inOrderTraversal(Node root, StringBuilder result) {
        // if (root == null) {
        //     return;     Can't code like usual Inorder traversal, Here, Have to return StringBuilder
        // }
        if (root.getLeftChild() != null) {
            inOrderTraversal(root.getLeftChild(), result);
        }

        result.append(root.getData() + ",");

        if (root.getRightChild() != null) {
            inOrderTraversal(root.getRightChild(), result);
        }

        return result;
    }

    public static void main(String[] args) {
        BinarySearchTree bsT = new BinarySearchTree();

        bsT.insert(6);
        bsT.insert(4);
        bsT.insert(9);
        bsT.insert(5);
        bsT.insert(2);
        bsT.insert(8);

        System.out.println(findKthMax(bsT.getRoot(),3)); // 6
    }
}
