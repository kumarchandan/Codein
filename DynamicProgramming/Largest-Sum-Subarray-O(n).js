/**
 * Given an array, find the contiguous subarray with the largest sum.
 */

/**
 * Kadane's algorithm:
 * Scan the entire array and at each position find the maximum sum of the subarray ending there
 * 
 * Initialize:
 * current_max = A[0]
 * global_max = A[0]
 * 
 * for i = 1 -> size of A
 *  if current_max is less than 0
 *   then current_max = A[i]
 *  otherwise
 *   current_max = current_max + A[i]
 *  if global_max is less than current_max
 *   then global_max = current_max
 * 
 * My Take:
 * Take first index value of arr as current and global max
 * At each iteration,
 *  If current max is less than 0, restart current max with this current index value
 *  else increase current max by adding this index value
 *  Also if global max is less than current max, assign current max to global max
 */
/**
 * Runtime Complexity: O(n)
 * Time Complexity: O(1)
 */

let findMaxSumSubArray = function(arr) {
    let current_max = arr[0];
    let global_max = arr[0];

    for (let i = 1; i < arr.length; i++) {
        if (current_max < 0) {
            current_max = arr[i];
        } else {
            current_max += arr[i];
        }
        if (global_max < current_max) {
            global_max = current_max;
        }
    }
    return global_max;
}

// Tests
console.log(findMaxSumSubArray([1,10,-1,11,5,-30,-7,20,25,-35])); // 45
console.log(findMaxSumSubArray([-4, 2, -5, 1, 2, 3, 6, -5, 1])); // 12
console.log(findMaxSumSubArray([-15,-14,-10,-19,-5,-21,-10])); // -5


// TODO:
// Also return the start and end index of the calculated max value