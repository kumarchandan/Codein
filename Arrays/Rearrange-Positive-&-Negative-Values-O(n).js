/**
 * Given an array, can you re-arrange its elements in such a way that the negative
 * elements appear at one side and positive elements appear in the other?
 * 
 * Input: [10,-1,20,4,5,-9,-6]
 * Output: [-1,-9,-6,10,20,4,5]
 */

/**
 * With a leftMostPosElem pointer
 * 
 * Iterate over the entire array, and if we encounter a negative element, 
 * Swap it with the leftmost positive element
 * 
 * Runtime: O(n)
 * Memory: Constant O(1), Inplace
 */
 function reArrange(arr) {
    let leftMostPosEle = 0;
    let tmp;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] < 0) {
            if (i !== leftMostPosEle) {
                tmp = arr[i];
                arr[i] = arr[leftMostPosEle];
                arr[leftMostPosEle] = tmp;
            }
            leftMostPosEle += 1
        }
    }
    return arr;
}

// Tests
console.log(reArrange([10,-1,20,4,5,-9,-6])); // [-1,-9,-6,10,20,4,5]
console.log(reArrange([-1,5,-4,-3])); // [-1,-4,-3,5]
console.log(reArrange([300,-1,3,0])); // [-1,0,300,3]
console.log(reArrange([0,0,0,-2])); // [-2,0,0,0]