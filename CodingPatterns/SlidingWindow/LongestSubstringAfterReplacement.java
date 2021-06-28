package CodingPatterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, 
 * find the length of the longest substring having the same letters after replacement.
 * 
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 * 
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
 * 
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 * 
 * hashMap={}
 * 
 * Iterate through the string to add one letter at a time in the window
 * Keep track of the count of the maximum repeating letter in any window -> `maxRepeatLetterCount`
 * 
 * 
 */
 /**
 * Runtime: O(n) where ‘N’ is the number of letters in the input string.
 * Memory: O(1)
 * As we expect only the lower case letters in the input string,
 * we can conclude that the space complexity will be O(26) to store each letter’s frequency in the HashMap,
 * which is asymptotically equal to O(1).
 */
public class LongestSubstringAfterReplacement {
    
    public static int findLength(String str, int k) {
        int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, charMap.get(rightChar));
            // current window size is from windowStart to windowEnd, overall we have a letter which is
            // repeating 'maxRepeatLetterCount' times, this means we can have a window which has one letter 
            // repeating 'maxRepeatLetterCount' times and the remaining letters we should replace.
            // if the remaining letters are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' letters
            if ((windowEnd - windowStart + 1) - maxRepeatLetterCount > k) { // e.g. abbbccb, k = 2, (6 - 1 + 1) - 4 (of b) = 2, so 2 == k, no need to shrink and this will be maxLength
                char leftChar = str.charAt(windowStart);
                charMap.put(leftChar, charMap.get(leftChar) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringAfterReplacement.findLength("aabccbb", 2)); // 5
        System.out.println("Length of the longest substring: " + LongestSubstringAfterReplacement.findLength("abbcb", 1)); // 4
        System.out.println("Length of the longest substring: " + LongestSubstringAfterReplacement.findLength("abccde", 1)); // 3
    }
}
