/**
 * Extension of Dynamic-Programming/Largest-Sum-Subarray-O(n).js
 * Given an array, find the contiguous subarray with the largest sum and
 * also, return its starting and ending indices
 * 
 * Input: [-2, 10, 7, -5, 15, 6]
 * Output: [33, 1, 5]
 */

let findMaxSumSubArray = (arr) => {
    let currMax = arr[0];
    let globalMax = arr[0];
    let startIdx = 0;
    let endIdx = 0;

    for (let i = 1; i < arr.length; i++) {
        //
        if (currMax < 0) {
            currMax = arr[i]; // start index
            startIdx = i;
        } else {
            currMax += arr[i];
        }
        //
        if (currMax > globalMax) {
            globalMax = currMax;
            endIdx = i; // latest end index where globalMax is udpated
        }
    }
    return [globalMax, startIdx, endIdx];
}

// Tests
console.log(findMaxSumSubArray([-2, 10, 7, -5, 15, 6])); // 33, 1, 5
console.log(findMaxSumSubArray([1,10,-1,11,5,-30,-7,20,25,-35])); // 45, 7, 8
console.log(findMaxSumSubArray([-15,-14,-10,-19,-5,-21,-10])); // -5, 6, 4 // It's just one idx as startIdx > endIdx