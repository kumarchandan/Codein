/**
 *  Given an array of integers, rotate the array by NN elements where NN is an integer:
 *    For positive values of NN, perform a right rotation.
 *    For negative values of NN, perform a left rotation.
 *    Make sure you make changes to the original array.
 * 
 * 
 * Runtime Comoplexity: Linear O(n)
 * Memory Complexity: Linear O(n)
 * 
 * Here is how the solution works:
 *    Store the last N elements into a temporary array.
 *    Shift the original array towards the right by L−N places. Here, L is the length of the ​array.
 *    Copy the temporary array at the beginning of the original array.
 */

let rotateArray = function(arr, n) {
  let len = arr.length;

  // Lets normalize the rotations
  // if n > array_size or n is negative
  n = n % len;
  if (n < 0) {
    // calculate the positive rotations needed
    n = n + len;
  }

  let temp = [];

  // copy last n elements of array into temp
  for (let i = 0; i < n; i++) {
    temp[i] = arr[len - n + i];
  }

  // shift original array
  for (let i = len - 1; i >= n; i--) {
    arr[i] = arr[i - n];
  }

  // copy temp into original array
  for (let i = 0; i < n; i++) {
    arr[i] = temp[i];
  }
};

// let arr = [1, 10, 20, 0, 59, 86, 32, 11, 9, 40];

// console.log("Array Before Rotation");
// console.log(arr)

// rotateArray(arr, 2);

// console.log("Array After Rotation");
// console.log(arr)

let arr2 = [1,2,3,4,5];
console.log("Array Before Rotation");
console.log(arr2)

rotateArray(arr2, 2);

console.log("Array After Rotation");
console.log(arr2) // [4,5,1,2,3]
