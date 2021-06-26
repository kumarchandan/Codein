package Trie;

public class TrieNode {
    TrieNode[] children;
    boolean isEndWord; // will be true if the node represents the end of word

    static final int ALPHABET_SIZE = 26; // Total # of English Alphabets = 26

    TrieNode() {
        this.isEndWord = false;
        this.children = new TrieNode[ALPHABET_SIZE];
    }

    // function to mark the current node as leaf
    public void markAsLeaf() {
        this.isEndWord = true;
    }

    // function to unmark the current node as leaf
    public void unMarkAsLeaf() {
        this.isEndWord = false;
    }
}
