package Trie;

import java.util.Arrays;

/**
 * If you are given a dictionary and a word, can you use a Trie to find if 
 * the given word can be formed by combining two dictionary words?
 * 
 * Input:
 * String dict[] = {"the" ,"hello", "there", "answer", "any", "Dragon", "world", "their", "inc"};
 * String word = "helloworld"
 * 
 * Ouput:
 * true
 */

 /**
  * Runtime: O(n)
  * If the length of the longest word in the dictionary is h, then the time taken for trie construction is O(m×h). 
  * Let the length of the word being searched be n. Then, the lookup phase takes O(n). 
  * So, overall, the given solution is O(mh+n) or O(max(mh,n)). We could argue that in some applications, 
  * the trie is constructed only once, and then many many lookups are performed. 
  * So, the cost of trie creation is amortized over all the lookups. In that case, the complexity reduces to O(n).
  */
public class WordFormationFromDictionary {

    public static boolean isFormationPossible(String[] dict, String word) {
        // Built Trie
        Trie trie = new Trie();
        for (int i = 0; i < dict.length; i++) {
            trie.insert(dict[i]);
        }

        for (int i = 0; i < word.length(); i++) {
            // Slice the words into two parts at each iteration
            String firstPart = word.substring(0, i);
            String secondPart = word.substring(i, word.length());

            // Check If both the parts are present in the `trie`
            if (trie.search(firstPart) && trie.search(secondPart)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String dict[] = {"the", "hello", "there", "answer","any", "dragon", "world", "their",  "inc"};
        System.out.println("Keys: "+ Arrays.toString(dict));

        System.out.println("Word formation answerdragon possible? " + WordFormationFromDictionary.isFormationPossible(dict, "answerdragon"));
    }
}
