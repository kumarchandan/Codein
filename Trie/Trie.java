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

    public static void main(String[] args) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their", "abc"};
        Trie trie = new Trie();

        System.out.println("Keys to insert: "+ Arrays.toString(keys) + "\n");

        // Construct Trie
        for (int i = 0; i < keys.length; i++) {
            trie.insert(keys[i]);
            System.out.println("\""+ keys[i]+ "\"" + "Inserted.");
        }
        System.out.println("Done");
    }
}
