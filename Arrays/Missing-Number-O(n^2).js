/**
 * https://leetcode.com/problems/missing-number/
 * 
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number
 * in the range that is missing from the array.
 * 
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */
/**
* Find the Max from the list
* counter = 0
* Iterate until Max by incrementing a counter value by 1
* Compare and find the missing number
**/

/**
 * Runtime Complexity: O(n^2)
 * Space Complexity: O(1)
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
    let maxNum = Math.max(...nums);
    let counter = 0; // Check from [0, n]
    let missingNum = nums.length;
    
    while (counter < maxNum) { // O(n)
        if (nums.indexOf(counter) > -1) { // O(n)
            counter++;
        } else {
            missingNum = counter;
            break;
        }
    }
    return missingNum;
};


//
console.log(missingNumber([3,0,1])); // 2
console.log(missingNumber([0, 1])); // 2
console.log(missingNumber([0])); // 1
console.log(missingNumber([1])); // 0