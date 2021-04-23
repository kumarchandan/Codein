/**
 *  Given an array of integers, rotate the array by NN elements where NN is an integer:
 *    For positive values of N, perform a right rotation.
 *    For negative values of N, perform a left rotation.
 *    Make sure you make changes to the original array.
 */
/**
 * Runtime Complexity: O(n*m) : n rotate by value, m (unshift and shift fn runs on O(n))
 * Memory Complexity: 
 */
let rotateArray = function(arr, n) {
  if (n > 0) {
    while(n > 0) {
      let elem = arr.pop();
      arr.unshift(elem);
      n--;
    }
  } else if (n < 0) {
    while (n < 0) {
      let elem = arr.shift();
      arr.push(elem);
      n++;
    }
  } else {
    return arr;
  }
  return arr;
};

console.log('Rotated Array: ', rotateArray([1,2,3,4,5], 2)) // [4,5,1,2,3]
