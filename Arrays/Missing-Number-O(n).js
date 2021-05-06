/**
 * https://leetcode.com/problems/missing-number/
 * 
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number
 * in the range that is missing from the array.
 * 
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */
/**
 * 
 */
/**
 * Runtime Complexity: O(n)
 * Space Complexity: O(1)
 */

var missingNumber = function(nums) {
    // Based on formulae: Sum of natural numbers series until n:	n(n+1)/2
    const expectedSum = (nums.length * (nums.length + 1)) / 2;
    const actualSum = nums.reduce((acc, curr) => acc + curr, 0); // O(n)
    return expectedSum - actualSum;
};

//
console.log(missingNumber([3,0,1])); // 2
console.log(missingNumber([0, 1])); // 2
console.log(missingNumber([0])); // 1
console.log(missingNumber([1])); // 0