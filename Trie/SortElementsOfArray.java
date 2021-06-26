package Trie;

import java.util.ArrayList;

/**
 * If you are given an array of strings, can you sort its elements using a Trie data structure?
 * 
 * Input:
 * String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their","abc"};
 * 
 * Output:
 * {"a", "abc", "answer", "any", "by", "bye", "the", "their", "there"}
 */

/**
 * Similar to `FindAllWordsInTrie`, only diff. is that we have to create the trie ourselves.
 * 
 * Since the children array for each node stores alphabets in alphabetical order, 
 * the tree itself is ordered from top to bottom. All we need to do is make a pre-order 
 * traversal (think of a as the left most child and z as the right most child) and store 
 * the words in a list.
 * 
 * Runtime:
 * We first insert the nodes into the graph and then traverse all the existing nodes.
 * Hence, the bottleneck worst case time complexity is O(n).
 * 
 */
public class SortElementsOfArray {

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
    
    public static ArrayList<String> sortArray(String []arr) {
        Trie trie = new Trie();
        // Build Trie
        for (int i = 0; i < arr.length; i++) {
            trie.insert(arr[i]);
        }
        
        ArrayList<String> resList = new ArrayList<>();
        char[] charArr = new char[20];

        getWords(trie.getRoot(), resList, 0, charArr);
        return resList;
    }

    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "answer", "any", "by", "bye", "their","abc"};

        ArrayList<String> arrList = SortElementsOfArray.sortArray(words);
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }
    }

}
