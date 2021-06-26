package Trie;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * If you are given a Trie, can you return every word it contains in sorted order?
 * 
 * Input:
 * root of a Trie instance storing {"the", "a", "there", "answer", "any", "by", "bye", "their","abc"}
 * 
 * Output:
 * "a", "abc","answer","any","by","bye","the","their","there"
 * 
 */

/**
 * As the algorithm traverses all the nodes, its run time is O(n) where n is the number of nodes in the trie.
 */
public class FindAllWordsInTrie {
    
    // Recursive Function to generate all words
    public static void getWords(TrieNode root, ArrayList<String> resList, int level, char[] charArr) {

        // Leaf denotes end of a word
        if (root.isEndWord) {
            // Current word is stored till the 'level' in the charArr
            String temp = "";
            for (int i = 0; i < level; i++) {
                temp += Character.toString(charArr[i]);
            }
            resList.add(temp);
        }

        for (int j = 0; j < 26; j++) {
            if (root.children[j] != null) {
                // Non-null child, so add this index to charArr
                charArr[level] = (char) (j + 'a'); // 0 + 'a' = 'a', 1 + 'a' = 'b' and so on...
                getWords(root.children[j], resList, level + 1, charArr);
            }
        }
    }

    public static ArrayList<String> findWords(TrieNode root) {
        ArrayList<String> resList = new ArrayList<>();
        char[] charArr = new char[20];
        getWords(root, resList, 0, charArr);
        return resList;
    }

    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                         "by", "bye", "their","abc"};
        Trie trie = new Trie();
    
        System.out.println("Keys: "+ Arrays.toString(keys));
    
        // Construct trie
        for (int i = 0; i < keys.length ; i++) {
            trie.insert(keys[i]);
        }

        ArrayList <String> list = findWords(trie.getRoot());

        for(int i = 0; i < list.size(); i++) {
          System.out.println(list.get(i));
        }
    
      }
}
