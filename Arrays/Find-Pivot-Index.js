/**
 * https://leetcode.com/problems/find-pivot-index/
 * 
 * Given an array of integers nums, calculate the pivot index of this array.
 * 
 * The pivot index is the index where the sum of all the numbers strictly to the left of 
 * the index is equal to the sum of all the numbers strictly to the index's right.
 * 
 * If the index is on the left edge of the array, then the left sum is 0 because there 
 * are no elements to the left. This also applies to the right edge of the array.
 * 
 * Return the leftmost pivot index. If no such index exists, return -1.
 */

/**
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * 
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 */

/**
 * Traverse array
 *  Calculate sum of the left side of current index and sum of right side of the current index
 *  If equals set the index as pivot index
 * 
 */

/**
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function(nums) {
    
    let pivotIdx = -1;

    for (let i = 0; i < nums.length; i++) {
        let leftSum = 0;
        let rightSum = 0;
        let leftIdx = i - 1;
        let rightIdx = i + 1;

        while(leftIdx >= 0) {
            leftSum += nums[leftIdx];
            leftIdx--;
        }

        while(rightIdx < nums.length) {
            rightSum += nums[rightIdx];
            rightIdx++;
        }

        if (leftSum === rightSum) {
            pivotIdx = i;
            break; 
        }
    }
    return pivotIdx;
};

//
console.log(pivotIndex([1,7,3,6,5,6])); // 3
console.log(pivotIndex([1,2,3])); // -1
console.log(pivotIndex([2,1,-1])); // 0
