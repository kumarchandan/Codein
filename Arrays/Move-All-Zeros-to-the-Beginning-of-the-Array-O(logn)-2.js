/**
 * Given an integer array, move all elements that are 0 to the left while maintaining the order
 * of other elements in the array. The array has to be modified in-place.
 * 
 * Input: [1,10,-1,11,5,0,-7,0,25,-35]
 * Output: [0,0,1,10,-1,11,5,-7,25,-35]
 * 
 * Note: We need to maintain the order of non-zero elements.
 */

/**
 * Runtime Complexity: Linear O(n)
 * Memory Complexity: O(1)
 */

/**
 * Variables:
 *  readIndex: traverses the entire array and stops at non-zero element to be written at writeIndex
 *  writeIndex: Stops where 0 is found
 * 
 * Steps:
 *  Traverse the array from BACK with readIndex and writeIndex until both of them reaches -1
 *   If readIndex finds 0, skip
 *   If readIndex finds non-0, Update it's value at writeIndex, decrement writeIndex
 *   decrement readIndex
 *   When readIndex reaches -1, write rest of the blocks with 0 until writeIndex also reaches 0
 *  Return arr
 */

let moveZerosToLeft = function(arr) {
  if (arr.length < 1) {
    return;
  }

  let lengthA = arr.length;
  let writeIndex = lengthA - 1;
  let readIndex = lengthA - 1;

  while (readIndex >= 0) {
    if (arr[readIndex] != 0) {
      arr[writeIndex] = arr[readIndex];
      writeIndex--;
    }
    
    readIndex--;
  }
  
  while (writeIndex >= 0) {
    arr[writeIndex] = 0;
    writeIndex--;
  }
};

let v = [1, 10, 20, 0, 59, 63, 0, 88, 0];
console.log("Original Array: [" + v + "]");

moveZerosToLeft(v);

console.log("After Moving Zeros: [" + v+ "]");

// Tests
console.log(moveZerosToLeft([1, 10, 20, 0, 59, 63, 0, 88, 0])) // [0, 0, 0, 1, 10, 20, 59, 63, 88]
console.log(moveZerosToLeft([1,10,-1,11,5,0,-7,0,25,-35])) // [0, 0, 1, 10, -1, 11, 5, -7, 25, -35]