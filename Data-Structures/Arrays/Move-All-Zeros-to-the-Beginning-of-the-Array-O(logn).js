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
 *  Traverse the array from back with readIndex and writeIndex until both of them reaches -1
 *   If readIndex finds 0, skip
 *   If readIndex finds non-0, Update it's value at writeIndex, decrement writeIndex
 *   decrement readIndex
 *   When readIndex reaches -1, write rest of the blocks with 0 until writeIndex also reaches 0
 *  Return arr
 */

let moveZerosToLeft = function(arr) {
  let readIndex = arr.length - 1;
  let writeIndex = arr.length - 1;

  while(writeIndex >= 0) {
    // readIndex is exhausted, write 0s in remaining writeIndexes
    if (readIndex < 0) {
      arr[writeIndex] = 0;
      writeIndex--;
      continue;
    }
    // Found non-0
    if(arr[readIndex] !== 0) {
      arr[writeIndex] = arr[readIndex]
      writeIndex--;
    }
    readIndex--;
  }
  return arr;
}

// Tests
console.log(moveZerosToLeft([1, 10, 20, 0, 59, 63, 0, 88, 0])) // [0, 0, 0, 1, 10, 20, 59, 63, 88]
console.log(moveZerosToLeft([1,10,-1,11,5,0,-7,0,25,-35])) // [0, 0, 1, 10, -1, 11, 5, -7, 25, -35]