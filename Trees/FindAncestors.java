package Trees;

/**
 * Find Ancestors of a Given Node in a Binary Tree
 * 
 * Given the root to a Binary Search Tree and a node value "k", write a function 
 * to find the ancestor of that node.
 * 
 * 
 */

/**
 * Runtime: O(h) : where h is height of the tree
 *          O(n) : worst case - skewed tree
 */
public class FindAncestors {
    
    public static String findAncestors(Node root, int k) {
        String result = "";
        Node tempNode = root;

        while (tempNode != null && tempNode.getData() != k) {

            result = result + tempNode.getData() + ","; // These are Ancestors

            if (k == tempNode.getData()) {
                return result;
            }
            if (k < tempNode.getData()) {
                tempNode = tempNode.getLeftChild();
            } else {
                tempNode = tempNode.getRightChild();
            }
        }

        if (tempNode == null) { // If tempNode is null, element wasn't found
            return "";
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
		/* Construct a binary tree like this
				6
			   / \
			  4   9
			 / \  |  \
			2	5 8	  12
					  / \
					 10  14 
		*/
		tree.insert(6); 
		tree.insert(4); 
		tree.insert(9); 
		tree.insert(2); 
		tree.insert(5); 
		tree.insert(8); 
		tree.insert(8); 
		tree.insert(12); 
		tree.insert(10); 
		tree.insert(14); 

		int key = 10; 
		System.out.print(key + " --> ");
		System.out.print(findAncestors(tree.getRoot(), key)); // 10 --> 6,9,12,

		System.out.println();
		key = 5; 
		System.out.print(key + " --> ");
		System.out.print(findAncestors(tree.getRoot(), key)); // 5 --> 6,4
    }
}
