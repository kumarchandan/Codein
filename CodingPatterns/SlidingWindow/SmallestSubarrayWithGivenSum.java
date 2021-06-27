package CodingPatterns.SlidingWindow;

/**
 * Given an array of positive numbers and a positive number ‘S,’ 
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. 
 * Return 0 if no such subarray exists.
 * 
 * Input: [2, 1, 5, 2, 3, 2], S=7 
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
 * 
 * Input: [2, 1, 5, 2, 8], S=7 
 * Output: 1
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
 * 
 * Input: [3, 4, 1, 1, 6], S=8 
 * Output: 3
 * Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
 */

/**
 * Runtime: O(n)
 * The outer for loop runs for all elements, and the inner while loop processes each element only once;
 * therefore, the time complexity of the algorithm will be O(N+N), which is asymptotically equivalent to O(N).
 * 
 * Memory: O(1)
 */
public class SmallestSubarrayWithGivenSum {

    public static int findMinSubArray(int[] arr, int S) {
        int windowSum = 0;
        int minLen = Integer.MAX_VALUE;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // Add next element coming to window
            
            // Shrink the window as small as possible until the 'windowSum' is smaller than 'S'
            while(windowSum >= S) {
                minLen = Math.min(minLen, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart]; // Subtract the elem going out of window
                windowStart++; // slide window
            }

        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 2, 3, 2 };

        System.out.println(SmallestSubarrayWithGivenSum.findMinSubArray(arr, 7)); // 2
    }
}
