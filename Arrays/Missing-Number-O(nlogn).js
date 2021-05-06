/**
 * https://leetcode.com/problems/missing-number/
 * 
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number
 * in the range that is missing from the array.
 * 
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */

/**
 * Runtime Complexity: O(nlogn)
 * Space Complexity: O(1)
 */

/**
 * Runtime Complexity: Depends on the implementation of the sort function that we use to sort the array of numbers. 
 * In v8, for large arrays, quicksort is used (i.e. O(nlogn))
 * Space complexity: O(1) since we need constant space to store the missing number.
 */
var missingNumber = function(nums) {
    nums.sort((a, b) => a - b);
    // If all numbers from i = 0 to n - 1 are in the array,
    // then the missing number is n (i.e. nums.length)
    let missingNumber = nums.length;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== i) {
            missingNumber = i;
            break;
        }
    }
    return missingNumber;
};

//
console.log(missingNumber([3,0,1])); // 2
console.log(missingNumber([0, 1])); // 2
console.log(missingNumber([0])); // 1
console.log(missingNumber([1])); // 0