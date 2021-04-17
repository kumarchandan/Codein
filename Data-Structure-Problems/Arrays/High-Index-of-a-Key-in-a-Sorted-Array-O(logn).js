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
  let start = 0;
  let end = arr.length - 1;
  let lowIndex = -1;

  while (start <= end) {
    let mid = Math.floor((start + end) / 2);

    // Case 1: Found the key in middle
    if (arr[mid] === key) {
      // Consider it lowestIndex and check further on the left side
      lowIndex = mid;
      // Try the left half now
      end = mid - 1;
    } else if (arr[mid] < key) { // Case 2: Key not found, check if it's higher or lower
      start = mid + 1;
    } else if (arr[mid] > key) {
      end = mid - 1;
    }
  }
  return lowIndex;
}

let findHighIndex = function(arr, key) {
  let start = 0;
  let end = arr.length - 1;
  let highIndex = -1;

  while (start <= end) {
    let mid = Math.floor((start + end) / 2)

    // Case 1: Found the key
    if (arr[mid] === key) {
      // Save it as the highestIndex, Check further on right side
      highIndex = mid;
      start = mid + 1;
    } else if (arr[mid] > key) { // Case 2: Key not found, Check further
      end = mid - 1;
    } else if (arr[mid] < key) {
      start = mid + 1;
    }
  }
  return highIndex;
}

// Tests
const arr = [ 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6 ];
console.log(findLowIndex(arr, 5)); // 15
console.log(findHighIndex(arr, 5)); // 17

console.log(findLowIndex(arr, 2)); // 3
console.log(findHighIndex(arr, 2)); // 7

console.log(findLowIndex(arr, 8)); // -1
console.log(findHighIndex(arr, 8)); // -1
 