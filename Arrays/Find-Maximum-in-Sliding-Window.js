/**
 * Given a large array of integers and a window of size w, 
 * find the current maximum value in the window as the window slides through the entire array.
 * 
 * Input: [-4, 2, -5, 3, 6], windowSize=3
 * Output: 2, 3, 6
 */

/** 
 * Runtime Complexity: O (n * w)  = for_loop * while_loop
 * Memory Complexity: O(w)
*/

/**
 * Pointers: 
 * p1 (starts from 0) - holds first value of the window
 * tp1 (always p1 plus 1) - holds second and later other values of the window
 * p2 - holds last value of the window
 * 
 * Steps:
 * Loop over array until p2 > length of array
 *  With while loop - Traverse through first value of window till last value to find the max and push this value to arr
 */

let findMaxSlidingWindow = function(arr, windowSize) {
  var result = [];

  let p1 = 0;
  let p2 = windowSize - 1;
  let len = arr.length;
  // 
  for (p1; p2 < len; p1++) {
    let tp1 = p1 + 1;
    let max = arr[p1];
    while (tp1 <= p2) {
      if (arr[tp1] > max) {
        max = arr[tp1];
      }
      tp1++;
    }
    result.push(max);
    p2++;
  }
  return result;
};

// Tests
console.log(findMaxSlidingWindow([-4, 2, -5, 3, 6], 3))       // 2, 3, 6
// console.log(findMaxSlidingWindow([1,2,3,4,3,2,1,2,5], 4)) // 4,4,4,4,3,5
// console.log(findMaxSlidingWindow([1,2,3,4,3,2,1,2,5], 3)) // 3,4,4,4,3,2,5
// console.log(findMaxSlidingWindow([1,2,3,4,3,2,1,2,5], 5)) // 4,4,4,4,5