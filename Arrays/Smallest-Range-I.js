/**
 * Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
 * After this process, we have some array B.
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 * 
 * Input: A = [1,3,6], K = 3
 * Output: 0
 * Explanation: B = [3,3,3] or B = [4,4,4]
 * 
 * Input: A = [0,10], K = 2
 * Output: 6
 * Explanation: B = [2,8]
 */
/**
 * Runtime Complexity: O(n)
 * Memory Complexity: O(1)
 */

/**
 * @param {number[]} A
 * @param {number} K
 * @return {number}
 */
var smallestRangeI = function(A, K) {
    let max = Number.MIN_VALUE;
    let min = Number.MAX_VALUE;

    for (let number of A) {
        if (number > max) {
            max = number;
        }
        if (number < min) {
            min = number;
        }
    }
    const difference = max - K - (min + K);
    return Math.max(difference, 0);
};

//
// console.log(smallestRangeI([1,3,6], 3)); // 0
console.log(smallestRangeI([0,10], 2)); // 6
