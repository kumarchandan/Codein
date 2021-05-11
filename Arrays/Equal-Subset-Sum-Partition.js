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
 * Basic Solution
 * This problem follows the 0/1 Knapsack pattern. A basic brute-force solution could be to try all combinations 
 * of partitioning the given numbers into two sets to see if any pair of sets has an equal sum.
 * 
 * Assume if S represents the total sum of all the given numbers, then the two equal subsets must have a sum equal to S/2. 
 * This essentially transforms our problem to: "Find a subset of the given numbers that has a total sum of S/2".
 * 
 */

let canPartition = function(num) {
    let sum = num.reduce((acc, val) => acc + val);

    // if 'sum' is an odd number, we can't have two subsets with equal sum
    if (sum % 2 !== 0) {
        return false;
    }

    return canPartitionRecursive(num, sum / 2, 0);
}

function canPartitionRecursive(num, sum, currentIndex) {
    // base check
    if (sum === 0) {
        return true;
    }
    
    if (num.length === 0 || currentIndex >= num.length) {
        return false;
    }

    // recursive call after choosing the number at the currentIndex
    // if the number at currentIndex exceeds the sum, we shouldn't process this
    if (num[currentIndex] <= sum) {
        if (canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1)) {
            return true;
        }
    }

    // recursive call after excluding the number at the currentIndex
    return canPartitionRecursive(num, sum, currentIndex + 1);
}

// Tests
console.log(canPartition([1,2,3,4])) // true {1, 4} & {2, 3}
console.log(canPartition([1,1,3,4,7])) // true {1, 3, 4} & {1, 7}
console.log(canPartition([2,3,4,6])) // false
