package Trie;

import java.util.Arrays;

/**
 * If you are given a Trie, can you find the total number of words it contains? 
 * 
 * Input:
 * Root of a Trie instance {"the", "a", "there", "answer", "any", "by", "bye", "their","abc"};
 * 
 * Output: 9
 * 
 * Starting from root Traverse all possible path
 *  Increase the count whenever find `isEndWord` true
 */

/**
 * Since the array under each node is traversed and checked for children, the worst-case running time is O(d^h),
 * where d is the size of the alphabet (26 for English), and h is the length of the longest word in the dictionary.
 * Note that d is constant, but h is not. So, this is an exponential function.
 */
public class TotalNoOfWordsInTrie {
    
    public static int totalWords(TrieNode root) {
        int count = 0;

        if (root.isEndWord == true) {
            count++;
        }

        for (int i = 0; i < 26; i++) {
            if(root.children[i] != null) {
                count += totalWords(root.children[i]);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "answer", "any", "by", "bye", "their","abc"};

        System.out.println("Keys: "+ Arrays.toString(words));
        System.out.println("Length of arr: " + words.length);

        Trie trie = new Trie();

        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }

        System.out.println("Total words: " + TotalNoOfWordsInTrie.totalWords(trie.getRoot()));
    }
}
