/**
 * Given the roots of two binary trees, determine if these trees are identical or not.
 */

const BinaryTreeNode = require("./BinaryTreeNode");
const { insert, displayLevelOrder } = require("./TreeNode");

/**
 * Runtime Complexity: Linear: O(n)
 * Memory Complexity: O(h) - Where h is the height of the tree
 * 
 * The recursive solution has O(h) memory complexity as it will consume memory on the stack 
 * up to the height of binary tree hh. It will be O(log n)for a balanced tree and, in the worst case, can be O(n).
 */

let areIdentical = function(root1, root2) {
    return false;
}

//
let root1 = new BinaryTreeNode(100);

insert(root1, 50);
insert(root1, 200);
insert(root1, 25);
insert(root1, 25);
insert(root1, 125);
insert(root1, 350);

displayLevelOrder(root1);
let root2 = createRandomBST