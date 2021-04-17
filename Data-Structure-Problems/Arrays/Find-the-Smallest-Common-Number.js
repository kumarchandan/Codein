/**
 * Given three integer arrays sorted in ascending order,
 * return the smallest number that is common in all three arrays.
 * 
 * Input: [1, 4, 6, 7, 8, 10, 14], [1, 4, 5, 6, 7, 8, 50], [0, 6, 7, 8, 10, 25, 30, 40]
 * Output: 6
 */
/**
 * Runtime Complexity: Linear O(n) : Traverses the array only once
 * Memory Complexity: Constant O(1)
 */

let findLeastCommonNumber = function(a, b, c) {
  let i = 0;
  let j = 0;
  let k = 0;

  while (i < a.length && j < b.length && k < c.length) {
    // Finding the smallest common number
    if (a[i] === b[j] && b[j] === c[k]) {
      return a[i];
    }

    // Find the smallest and increment it
    // a[i] is smallest
    if (a[i] < b[j] && a[i] < c[k]) {
      i++;
    } else if (b[j] < a[i] && b[j] < c[k]) {
      j++;
    // } else if (c[k] < a[i] && c[k] < b[j]) { // can cause infinite loop if none increases (in case two values are equal but other is not)
    //   k++;
    // }
    } else {
      k++;
    }
  }
  return -1;
};

// console.log(findLeastCommonNumber([1, 4, 6, 7, 8, 10, 14], [1, 4, 5, 6, 7, 8, 50], [0, 6, 7, 8, 10, 25, 30, 40]))
console.log('Least common number: ', findLeastCommonNumber([6,7,10,25,30,63,64], [1,4,5,6,7,8,50], [1,6,10,14]))
