package CodingPatterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * 
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * a, r -> 2 distict
 * 
 * 
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * a -> 1 distinct char
 * 
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 */

 /**
  * Traverse str with windowEnd
  *  Put char in a Set, go until size K
  *  When reaches size K, take a note of length and continue sliding
  */
/**
 * Runtime: O(n)
 * The outer for loop runs for all characters, and the inner while loop processes each character only once;
 * therefore, the time complexity of the algorithm will be O(N+N), which is asymptotically equivalent to O(N).
 * 
 * Memory: O(K)
 * We will be storing a maximum of K+1 characters in the HashMap.
 */
public class LongestSubstringKDistinctCharacters {

    public static int findLength(String str, int K) {
        if (str == null || str.length() == 0 || str.length() < K) {
            throw new IllegalArgumentException();
        }

        int windowStart = 0;
        int maxLen = 0;
        Map<Character, Integer> charMap = new HashMap<>(); // To store character frequency

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1); // Increment or Set to 1

            // Shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while(charMap.size() > K) {
                char leftChar = str.charAt(windowStart);
                // Get rid of chars from left
                charMap.put(leftChar, charMap.get(leftChar) - 1);
                if(charMap.get(leftChar) == 0) {
                    charMap.remove(leftChar);
                }
                windowStart++; // Shrink the window
            }
            // Store the max length so far before we traverse further in String
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        return maxLen;
    }
    
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinctCharacters.findLength("araaci", 2)); // 4
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinctCharacters.findLength("araaci", 1)); // 2
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinctCharacters.findLength("cbbebi", 3)); // 5
    }
}
