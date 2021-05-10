/**
 * Given an array of integers and a value, determine if there are any two integers in 
 * the array whose sum is equal to the given value.
 * 
 * Return true if the sum exists and return false if it does not.
 */
/**
 * Runtime Complexity: O(n)
 * Memory Complexity: O(1)
 */

let findSumOfTwo = function(A, val) {
    let i = 0;
    let j = A.length - 1;
    
    while (i < j) {
      let s = A[i] + A[j];
      if (s === val) {
        return true;
      }

      if (s < val) {
        i++;
      } else {
        j--;
      }
    }
    return false;
};

let v = [5, 7, 1, 2, 8, 4, 3];
let test = [3, 20, 1, 2, 7];

for (i = 0; i < test.length; i++) {
    let output = findSumOfTwo(v, test[i]);
    console.log("findSumOfTwo(v, " + test[i] + ") = " + output);
}