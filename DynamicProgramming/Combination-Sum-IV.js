/**
 * Given an array of distinct integers nums and a target integer target, return the 
 * number of possible combinations that add up to target.
 */
/**
 * Runtime Complexity: O(n)
 * Space Complexity: O(1)
 */


let combinationSum4 = function(nums, target) {
    const table = new Array(target + 1).fill(0);

    table[0] = 1;

    for (let i = 1; i <= target; i++) {
        for (let j = 0; j < nums.length; j++) {
            if (i - nums[j] >= 0) {
                table[i] += table[i - nums[j]];
            }
        }
    }
    return table[target];
};

// Tests
console.log(combinationSum4([1,2,3], 4)); // 7
console.log(combinationSum4([9], 3)); // 0

