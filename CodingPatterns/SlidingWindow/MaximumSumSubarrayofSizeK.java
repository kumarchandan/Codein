package CodingPatterns.SlidingWindow;

/**
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 * 
 * Input: [2, 1, 5, 1, 3, 2], k=3 
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 * 
 * Input: [2, 3, 4, 1, 5], k=2 
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */

public class MaximumSumSubarrayofSizeK {

    public static int maxSumSubArray(int[] arr, int k) {
        int windowSum = 0;
        int maxSum = 0;

        // Need sliding window of size k
        // Calculate sum of first sliding window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // Traverse rest of the array and calculate their averages using windowSum
        // Subtract the idx value going out, and Add the idx value coming in the sliding Window
        for (int i = 1; i <= arr.length - k; i++) {
            windowSum = windowSum - arr[i-1] + arr[i + k - 1];
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }

        return maxSum;
    }

    public static int maxSumSubArrays(int[] arr, int K) {
        int windowSum = 0;
        int windowStart = 0;
        int maxSum = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // Add incoming elment in window

            if (windowEnd >= K - 1) {
                maxSum = Math.max(windowSum, maxSum);
                windowSum -= arr[windowStart]; // Subtract the elment going out of window
                windowStart++; // Slide the window ahead
            }
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 1, 3, 2 };
        System.out.println(MaximumSumSubarrayofSizeK.maxSumSubArrays(arr, 3)); // 9

        int[] arr2 = {2, 3, 4, 1, 5};
        System.out.println(MaximumSumSubarrayofSizeK.maxSumSubArrays(arr2, 2)); // 7
    }
}
