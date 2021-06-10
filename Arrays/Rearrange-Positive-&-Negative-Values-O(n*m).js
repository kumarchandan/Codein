/**
 * Given an array, can you re-arrange its elements in such a way that the negative
 * elements appear at one side and positive elements appear in the other?
 * 
 * Input: [10,-1,20,4,5,-9,-6]
 * Output: [-1,-9,-6,10,20,4,5]
 */

/**
 * Traverse arr
 * when -ve found, move it towards left until another -ve is found or beginning of arr
 * 
 */

/**
 * i = 1, 2, 3, 4, 5, 6
 * j = 1, 0, 5, 6
 * 
 * 10, -1, 20, 4, 5, -9, -6
 * -1, 10, 20, 4, 5, -9, -6
 * -1, 10, 20, 4, -9, 5, -6
 * -1, 10, 20, -9, 4, 5, -6
 * -1, 10, -9, 20, 4, 5, -6
 * -1, -9, 10, 20, 4, 5, -6
 * -1, -9, 10, 20, 4, -6, 5
 * -1, -9, 10, 20, -6, 4, 5
 * -1, -9, 10, -6, 20, 4, 5
 * -1, -9, -6, 10, 20, 4, 5
 * 
 * Runtime: O(m * n)
 * Memory: Constant O(1), Inplace
 */
 function reArrange(arr) {
    for(let i = 1; i < arr.length; i++) {
        if (arr[i] < 0) { // If neg value found
            let j = i;
            // Move neg value towards left until positives are found or 
            // Index reaches to beginning
            while(j-1 >= 0 && arr[j-1] >= 0) { // 0 is considered +ve, so arr[j-1] >= 0
              // Swap
                let temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
    return arr;
}

// Tests
console.log(reArrange([10,-1,20,4,5,-9,-6])); // [-1,-9,-6,10,20,4,5]
console.log(reArrange([-1,5,-4,-3])); // [-1,-4,-3,5]
console.log(reArrange([300,-1,3,0])); // [-1,0,300,3]
console.log(reArrange([0,0,0,-2])); // [-2,0,0,0]