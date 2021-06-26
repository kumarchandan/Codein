package Trie;

import java.util.Arrays;

/**
 * A Trie uses TrieNode
 * Trie has -> root = new TrieNode()
 * Starting from root, there is possibility of filling 26 locations (each mapped with 26 letters) at each level down
 * 
 * Example:
 * word 'bar' is stored in Trie using TrieNode at each level like the following:
 * root - 0, 1, 2, .... 25 // Index 1 maps to 'b' is no more null, initialized with `new TrieNode()`
 *           |
 *           v
 *           0, 1, 2, ... 25 // Index 0 maps to 'a' is no more null, initialized with `new TrieNode()`
 *           |
 *           v
 *           0, 1, 2, ... 17... 25 // Index 17 maps to 'r' is no more null, initialized with `new TrieNode()`, Also `isEndWord` is set to true
 *                        |
 *                        v
 *           null...    null... null
 */

public class Trie {
    
    private TrieNode root; // root node

    public Trie() {
        root = new TrieNode();
    }

    // Get index of a character
    public int getIndex(char x) {
        // the index is based on the position of character in alphabets
        // if char is 'b', index will be 1 ('b' - 'a'), for 'c' it is 2 and so on...
        return x - 'a'; // returns diff. based on ASCII value
    }

    /**
     * Insert a key into the Trie
     * Runtime:
     * O(h), where h is length of the word
     * At worst case, at every level, for every character, `TrieNode` has to be created and inserted in `Trie`
     * 
     */
    public void insert(String key) {
        if (key == null) {
            return;
        }

        key = key.toLowerCase(); // keys are stored in lowercase
        TrieNode currentNode = this.root;

        int index = 0; // to store character index

        // Iterate the Trie with given character index
        // If it is null, then create a TrieNode and go down a level
        for (int i = 0; i < key.length(); i++) {
            index = getIndex(key.charAt(i));
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            // A level down
            currentNode = currentNode.children[index]; // null or TrieNode instance
        }
        // Mark the end character as leaf node
        currentNode.markAsLeaf();
    }

    /**
     * search 'bar'
     * root -> .1..  b
     *         0...  a
     *         ..17. r
     *         .1..  b
     * Traverse through 'bar'
     *  If each charIdx is found while traversing Trie then return true else false
     */
    /**
     * Runtime: O(h) where h is the length of the word
     * At worst case, we have to look at h consecutive levels of Trie
     * The presence or absence of each character from the key in the trie can be determined in O(1)
     * because the size of the alphabet is fixed.
     */
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        word = word.toLowerCase();

        boolean found = true;
        int charIdx = 0;
        TrieNode currentNode = this.root;
        /**
         * Iterate the Trie with given character index,
         * If it is null at any point then we stop and return false
         */
        for (int i = 0; i < word.length(); i++) {
            charIdx = getIndex(word.charAt(i));
            if (currentNode.children[charIdx] == null) {
                found = false;
                break;
            }
            currentNode = currentNode.children[charIdx]; // null or TrieNode instance
        }
        return found;
    }

    /**
     * Case 1: word to be deleted has no common subsequence, delete all the nodes
     * e.g. Delete 'bar'.
     * root -> b
     *         a
     *         r
     * Delete all nodes
     * Traverse through 'bar'
     *  If reached the leaf node with exact word 'bar', start setting nodes to null going backwards until 'b'
     * 
     * Case 2: word to be deleted is a prefix of some other word, only set the `isEndWord` flag to false at the end index of the word
     * e.g. Delete 'boy'
     * root -> b
     *         o
     *         y <- Only set `isEndWord` to false as word 'boys' needs 'boy' prefix
     *         s
     * 
     * How do I know if a word is a prefix or not?
     * After 'y', if any of the children index is not null, means the word is a part of another word
     * 
     * Traverse through 'boy'
     *  If after 'y', children exists then set the `isEndWord` to false
     * 
     * Case 3: word to be deleted has a common prefix, delete the nodes until `isEndword` flag is true is found up in the level
     * e.g. Delete 'boys'
     * root -> b
     *         o
     *         y
     *         s <- delete this node only
     * 
     * Traverse 'boys'
     *  delete the nodes until `isEndWord` flag true is found
     * 
     * Case 1 and Case 3 conditions can be merged
     */
    // public void delete(String word) {
    //     if (word == null) {
    //         return;
    //     }

    //     TrieNode currentNode = new TrieNode();
    //     int charIdx = 0;

    //     for (int i = 0; i < word.length(); i++) {
    //         charIdx = getIndex(word.charAt(i));

    //         // Case 0: Word not found
    //         if(currentNode.children[charIdx] == null) {
    //             System.out.println("Word not found!");
    //             return;
    //         }

    //         // Case 1 and Case 3
    //         if (i == word.length() - 1) { // have reached the last idx of word
                
    //         }
    //         currentNode = currentNode.children[charIdx];
    //     }


    // }

    // Helper Function to return true if currentNode does not have any children
    private boolean hasNoChildren(TrieNode currentNode) {
        for (int i = 0; i < currentNode.children.length; i++) {
            if ((currentNode.children[i]) != null)
                return false;
        }
        return true;
    }
    
    // Recursive function to delete given key
    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level) {
        boolean deletedSelf = false;

        if (currentNode == null) {
            System.out.println("Key does not exist");
            return deletedSelf;
        }

        // Base Case: If we have reached at the node which points to the alphabet at the end of the key.
        if (level == length) {
            // If there are no nodes ahead of this node in this path
            // Then we can delete this node
            if (hasNoChildren(currentNode)) {
                currentNode = null;
                deletedSelf = true;
            }
            // If there are nodes ahead of currentNode in this path
            // Then we cannot delete currentNode. We simply unmark this as leaf
            else {
                currentNode.unMarkAsLeaf();
                deletedSelf = false;
            }
        }
        else {
            TrieNode childNode = currentNode.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, childNode, length, level + 1);
            if (childDeleted) {
                // Making children pointer also null: since child is deleted
                currentNode.children[getIndex(key.charAt(level))] = null;
                // If currentNode is leaf node that means currntNode is part of another key
                // and hence we can not delete this node and it's parent path nodes
                if (currentNode.isEndWord) {
                    deletedSelf = false;
                }
                // If childNode is deleted but if currentNode has more children then currentNode must be part of another key.
                // So, we cannot delete currenNode
                else if (!hasNoChildren(currentNode)) {
                    deletedSelf = false;
                }
                // Else we can delete currentNode
                else {
                    currentNode = null;
                    deletedSelf = true;
                }
            }
            else {
                deletedSelf = false;
            }
        }
        return deletedSelf;
    }

    /**
     * Runtime: O(h)
     * If the length of the word is h, the worst-case time complexity is O(h).
     * In the worst case, we have to look at h consecutive levels of a trie for a character in the key being searched for.
     */
    public void delete(String key){
        if ((root == null) || (key == null)){
            System.out.println("Null key or Empty trie error");
            return;
        }
        deleteHelper(key, root, key.length(), 0);
    }

    public static void main(String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their", "abc"};
        Trie trie = new Trie();

        System.out.println("Keys to insert: "+ Arrays.toString(keys) + "\n");

        // Test Insertion Construct Trie
        for (int i = 0; i < keys.length; i++) {
            trie.insert(keys[i]);
            System.out.println("\""+ keys[i]+ "\"" + "Inserted.");
        }
        // Test Search
        System.out.println("Search Operation: ");
        System.out.println("Found bye? " + trie.search("bye"));
        System.out.println("Found byelaw? " + trie.search("byelaw"));

        // Test Deletion
        System.out.println("Found bye? " + trie.search("bye"));
        System.out.println("Deleting bye ");
        trie.delete("bye");
        System.out.println("Found bye? " + trie.search("bye"));
    }
}
