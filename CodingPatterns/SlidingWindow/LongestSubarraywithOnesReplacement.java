package CodingPatterns.SlidingWindow;

/**
 * Similar to `Longest Substring with same Letters after Replacement`.
 * 
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, 
 * find the length of the longest contiguous subarray having all 1s.
 * 
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 * 
 * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
 * Output: 9
 * Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
 * 
 */
/**
 * Runtime: O(n) where ‘N’ is the count of numbers in the input array.
 * Memory: O(1)
 */
public class LongestSubarraywithOnesReplacement {

    // public static int findLength(int[] arr, int k) { // <== WORKS TOO
    //     int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
    //     Map<Integer, Integer> charMap = new HashMap<>();

    //     // try to extend the range [windowStart, windowEnd]
    //     for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
    //         int rightChar = arr[windowEnd];
    //         charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1);
    //         maxRepeatLetterCount = Math.max(maxRepeatLetterCount, charMap.get(rightChar));

    //         if ((windowEnd - windowStart + 1) - maxRepeatLetterCount > k) {
    //             int leftChar = arr[windowStart];
    //             charMap.put(leftChar, charMap.get(leftChar) - 1);
    //             windowStart++;
    //         }
    //         maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    //     }
    //     return maxLength;
    // }
    public static int findLength(int[] arr, int k) {
        int windowStart = 0, maxLength = 0, maxOnesCount = 0;
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1) {
                maxOnesCount++;
            }
            // current window size is from windowStart to windowEnd, overall we have a maximum of 1s
            // repeating a maximum of 'maxOnesCount' times, this means that we can have a window with
            // 'maxOnesCount' 1s and the remaining are 0s which should replace with 1s.
            // now, if the remaining 0s are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' Os
            if ((windowEnd - windowStart + 1) - maxOnesCount > k) {
                if (arr[windowStart] == 1) {
                    maxOnesCount--;
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
    
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr1 = { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 };
        int[] arr2 = { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 };
        System.out.println(LongestSubarraywithOnesReplacement.findLength(arr1, 2)); // 6
        System.out.println(LongestSubarraywithOnesReplacement.findLength(arr2, 3)); // 9
    }
}
