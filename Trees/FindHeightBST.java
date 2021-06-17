package Trees;

/**
 * Find the Height of a Binary Search Tree
 * Given the root to a Binary Search Tree, write a function to find the height of the tree.
 * 
bst = {
    6 -> 4,9
    4 -> 2,5
    9 -> 8,12
    12 -> 10,14
}
where parent -> leftChild, rightChild

Output: 3

 * 
 */
public class FindHeightBST {
    /**
     *  Runtime: O(n) as all the nodes of the entire tree have to be traversed
     */
    public static int findHeight(Node root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(findHeight(root.getLeftChild()), findHeight(root.getRightChild()));
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
        
        System.out.println(findHeight(bsT.getRoot())); // 2
    }
}
