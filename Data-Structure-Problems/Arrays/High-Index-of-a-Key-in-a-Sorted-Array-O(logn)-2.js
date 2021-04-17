/**
 * Given a sorted array of integers, return the start and end index of the given key.
 * You must return -1 if the indexes are not found.
 * The array length can be in the millions with many duplicates.
 */

/**
 * Runtime Complexity: Logarithmic, O(log n)
 *  Even though we do binary search twice (one for high, one for low), asymptotic runtime complexity is still O (log n)
 * Memory Complexity: O(1)
 *  Since no extra storage is used
 *  Though if binary search was implemented recursively, there would be implicit O(log n) memory usage on the function call stack
 */
/**
 * Approach:
 * Variation in Binary Search
 */

let findLowIndex = function(arr, key) {
  let low = 0;
  let high = arr.length - 1;
  let mid = Math.floor(high / 2);

  while (low <= high) {

    let midElem = arr[mid];

    if (midElem < key) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }

    mid = low + Math.floor((high - low) / 2);
  }
  
  if (low < arr.length && arr[low] === key) {
    return low;
  }

  return -1;
};

let findHighIndex = function(arr, key) {
  let low = 0;
  let high = arr.length - 1;
  let mid = Math.floor(high / 2);

  while (low <= high) {
    let midElem = arr[mid];

    if (midElem <= key) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }

    mid = low + Math.floor((high - low) / 2);
  }

  if (high === -1){
    return high
  }
  
  if (high < arr.length && arr[high] === key) {
    return high;
  }

  return -1;
};

// Tests
let arr = [1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6];

var key = 5;
console.log("Low Index of " + key + ": " + (findLowIndex(arr, key)));
console.log("High Index of " + key + ": " + (findHighIndex(arr, key)));

key = -2;
console.log("Low Index of " + key + ": " + (findLowIndex(arr, key)));
console.log("High Index of " + key + ": " + (findHighIndex(arr, key)));


console.log(findLowIndex(arr, 5)); // 15
console.log(findHighIndex(arr, 5)); // 17

console.log(findLowIndex(arr, 2)); // 3
console.log(findHighIndex(arr, 2)); // 7

console.log(findLowIndex(arr, 8)); // -1
console.log(findHighIndex(arr, 8)); // -1
 