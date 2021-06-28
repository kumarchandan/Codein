package CodingPatterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;


/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Given a string, find the length of the longest substring, which has no repeating characters.
 * 
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 * 
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring without any repeating characters is "ab".
 * 
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * Input: s = "dvegef"
 * 
 * map = {d:1, v:1, e:2, g:3}
 * windowStart = 0
 * windowEnd = 2
 * maxLen = 2
 * 
 * Traverse with windowEnd
 *  Add d to map |
 *  Add v to map |
 *  Add e to map |
 *  Add g to map |
 *  e repeats -> put windowStart at g (which is next index of e), update new idx for this duplicate elem in hashMap
 *  Keep storing the maxLen so far -> Math.max(maxLen, (windowEnd - windowStart + 1))
 */

 /**
  * Runtime: O(n)
  * Memory: O(K) where K is no of distinct characters in string, so K can also be <= N
  */
public class NoRepeatSubstring {

    public static int findLength(String str) {
        if (str == null || str.length() == 0 || str.length() < 1) {
            throw new IllegalArgumentException();
        }

        int maxLen = 0;
        int windowStart = 0;
        // Store chars with index
        Map<Character, Integer> charMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (charMap.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, charMap.get(rightChar) + 1);
            }
            charMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1); // Store the maxLen so far
        }

        return maxLen;
    }
    
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abba")); // 2
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb")); // 3
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb")); // 2
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("pwwkew")); // 3 "dvdf"
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("dvdf")); // 3
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("")); // Throw exception
    }
}
