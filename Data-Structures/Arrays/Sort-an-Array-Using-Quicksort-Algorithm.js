/**
 * Given an integer array, sort it in ascending order using quicksort.
 */

/**
 * Runtime complexity: Linearithmic O(n log n)
 * Memory complexity: Logarithmic O(log n)
 * This recursive solution has an O(log n) memory complexity since it consumes memory on the stack.
 */

/**
 * Select a pivot element from the array to divide the array into two parts based on the pivot.
 * We pick the first element as the pivot if we follow Hoare’s algorithm. Another common approach is 
 * to select a random element as the pivot.
 * Reorder the array by comparing with the pivot element such that smaller values end up at the left side, 
 * and larger values end up at the right side of the pivot.
 * Now, the pivot element is in its correct sorted position.
 */

let partition = function(arr, low, high) {
  let pivotValue = arr[low];
  let i = low;
  let j = high;

  while (i < j) {
    while (i <= high && arr[i] <= pivotValue) {
      i++;
    }

    while (arr[j] > pivotValue) {
      j--;
    }

    if (i < j) {
      // Swap arr[i], arr[j]
      let temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
  }

  arr[low] = arr[j];
  arr[j] = pivotValue;

  // return the pivotIndex
  return j;
}

let quickSortRecursive = function(arr, low, high) {
  if (high > low) {
    let pivotIndex = partition(arr, low, high)
    quickSortRecursive(arr, low, pivotIndex - 1);
    quickSortRecursive(arr, pivotIndex + 1, high);
  }
}

let quickSort = function(arr) {
  quickSortRecursive(arr, 0, arr.length - 1);
}

// Tests
// console.log(quickSort([33,6,21,12,19,29,38,22,14,40])); // [6,12,14,19,21,22,29,33,38,40]

// let a = [55, 23, 26, 2, 18, 78, 23, 8, 2, 3];
let a = [5, 1, 2, 3, 4];

console.log("Before Sorting")
console.log(a);

quickSort(a);

console.log("After Sorting")
console.log(a);
