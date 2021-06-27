package CodingPatterns.SlidingWindow;

/**
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 * 
 * Input:
 * [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 * 
 * Output:
 * [2.2, 2.8, 2.4, 3.6, 2.8]
 */

/**
 * Use the already calculated sum between overlapping sliding window elements
 * Runtime: O(n)
 */
public class FindAvgOfSubArrayOfSizeK {
    
    public static double[] findAverage(int[] arr, int k) {
        double[] res = new double[arr.length - k + 1];
        double slidingWindowSum = 0;

        // Need sliding window of size k
        // Calculate sum of first sliding window
        for (int i = 0; i < k; i++) {
            slidingWindowSum += arr[i];
        }
        // Save the first average
        res[0] = slidingWindowSum / k;

        // Traverse rest of the array and calculate their averages using slidingWindowSum
        for (int i = 1; i <= arr.length - k; i++) {
            slidingWindowSum = slidingWindowSum - arr[i-1] + arr[i + k - 1];
            res[i] = slidingWindowSum / k;
        }

        return res;
    }

    public static double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= K - 1) {
                result[windowStart] = windowSum / K; // calculate the average
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 6, -1, 4, 1, 8, 2 };

        double[] avgSum = findAverage(arr, 5); // [2.2, 2.8, 2.4, 3.6, 2.8]
        for (int i = 0; i < avgSum.length; i++) {
            System.out.println(avgSum[i]);
        }
    }
}
