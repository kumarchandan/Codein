package CodingPatterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Permutation is defined as the re-arranging of the characters of the string.
 * For example, “abc” has the following six permutations:
 * abc, acb, bac, bca, cab, cba
 * If a string has ‘n’ distinct characters, it will have n!n! permutations.
 * 
 * Similar:  Longest Substring with K Distinct Characters
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * 
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 * 
 * Input: String="odicf", Pattern="dc"
 * Output: false
 * Explanation: No permutation of the pattern is present in the given string as a substring.
 * 
 * Input: String="bcdxabcdy", Pattern="bcdyabcdx"
 * Output: true
 * Explanation: Both the string and the pattern are a permutation of each other.
 * 
 * Input: String="aaacb", Pattern="abc"
 * Output: true
 * Explanation: The string contains "acb" which is a permutation of the given pattern.
 */

/**
 * Runtime: O(N + M), where ‘N’ and ‘M’ are the number of characters in the input string and the pattern, respectively
 * Memory: O(M) since, in the worst case, the whole pattern can have distinct characters that will go into the HashMap
 */
public class PermutationInString {

    public static boolean findPermutation(String str, String pattern) {
        if (str == null || str.length() == 0 || pattern == null) {
            throw new IllegalArgumentException();
        }

        int windowStart = 0;
        int matched = 0;
        Map<Character, Integer> patternCharMap = new HashMap<>();

        // Put frequency of characters of 'pattern' string in patternCharMap
        for (int i = 0; i < pattern.length(); i++) {
            patternCharMap.put(pattern.charAt(i), patternCharMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        // our goal is to match all the characters from the 'charFrequencyMap' with the current window
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            // Match the new character with characters in 'pattern'
            if(patternCharMap.containsKey(rightChar)) {
                // decrement the frequency of the matched character
                patternCharMap.put(rightChar, patternCharMap.get(rightChar) - 1);

                if(patternCharMap.get(rightChar) == 0) { // character is completely matched
                    matched++;
                }
            }

            if (matched == patternCharMap.size()) {
                return true;
            }

            // If the window size is greater than the length of the pattern, shrink the window to make it equal
            if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
                char leftChar = str.charAt(windowStart++);
                if (patternCharMap.containsKey(leftChar)) {
                    if (patternCharMap.get(leftChar) == 0) {
                        matched--; // before putting the character back, decrement the matched count
                    }
                    // put the character back for matching
                    patternCharMap.put(leftChar, patternCharMap.get(leftChar) + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(PermutationInString.findPermutation("oidbcaf", "abc")); // true
        System.out.println(PermutationInString.findPermutation("odicf", "dc")); // false
        System.out.println(PermutationInString.findPermutation("bcdxabcdy", "bcdyabcdx")); // true
        System.out.println(PermutationInString.findPermutation("aaacb", "abc")); // true
    }
}
