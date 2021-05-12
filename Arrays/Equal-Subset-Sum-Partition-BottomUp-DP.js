/**
 * Given a set of positive numbers, find if we can partition it into two subsets 
 * such that the sum of elements in both the subsets is equal.
 * 
 * Input: {1, 2, 3, 4}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
 * 
 * Input: {1, 1, 3, 4, 7}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 3, 4} & {1, 7}
 * 
 * Input: {2, 3, 4, 6}
 * Output: False
 * Explanation: The given set cannot be partitioned into two subsets with equal sum.
 */
/**
 * Runtime Complexity: O(n * s); where n = total numbers, s = total sum of all the numbers
 * Space Complexity: O(1)
 */


let canPartition = function(num) {
    const n = num.length;
    // find the total sum
    let sum = 0;
    for (let i = 0; i < n; i++) sum += num[i];
  
    // if 'sum' is a an odd number, we can't have two subsets with same total
    if (sum % 2 != 0) return false;
  
    // we are trying to find a subset of given numbers that has a total sum of ‘sum/2’.
    sum /= 2;
  
    const dp = Array(n)
      .fill(false)
      .map(() => Array(sum + 1).fill(false));
  
    // populate the sum=0 column, as we can always have '0' sum without including any element
    for (let i = 0; i < n; i++) dp[i][0] = true;
  
    // with only one number, we can form a subset only when the required sum is equal to its value
    for (let s = 1; s <= sum; s++) {
      dp[0][s] = num[0] == s;
    }
  
    // process all subsets for all sums
    for (let i = 1; i < n; i++) {
      for (let s = 1; s <= sum; s++) {
        // if we can get the sum 's' without the number at index 'i'
        if (dp[i - 1][s]) {
          dp[i][s] = dp[i - 1][s];
        } else if (s >= num[i]) {
          // else if we can find a subset to get the remaining sum
          dp[i][s] = dp[i - 1][s - num[i]];
        }
      }
    }
  
    // the bottom-right corner will have our answer.
    return dp[n - 1][sum];
};
  

// Tests
console.log(canPartition([1,2,3,4])) // true {1, 4} & {2, 3}
console.log(canPartition([1,1,3,4,7])) // true {1, 3, 4} & {1, 7}
console.log(canPartition([2,3,4,6])) // false
