/**
 * You are given an array (list) of interval pairs as input where each interval has a start and end timestamp. 
 * The input array is sorted by starting timestamps. You are required to merge overlapping intervals and return 
 * a new output array.
 * 
 * Input: [1, 5], [3, 7], [4, 6], [6, 8], [10, 12], [10, 15]
 * Output: [1, 8] [10, 15]
 * 
 * Intervals (1, 5), (3, 7), (4, 6), (6, 8) are overlapping so they should be merged to one big interval (1, 8).
 * Similarly, intervals (10, 12) and (12, 15) are also overlapping and should be merged to (10, 15).
 */

/**
 * Runtime Complexity:
 * Memory Complexity:
 */

/**
 * 
 */

class Pair { 
  constructor(first, second) { 
    this.first = first; 
    this.second = second; 
   } 
}

let mergeIntervals = function(v) {
  if (!v || v.length === 0) {
    return;
  }

  let result = [];
  result.push(new Pair(v[0].first, v[0].second));
  
  for (let i = 0; i < v.length; i++) {
    let x1 = v[i].first;
    let y1 = v[i].second;
    let x2 = result[result.length - 1].first;
    let y2 = result[result.length - 1].second;

    if (y2 >= x1) {
      result[result.length - 1].second = Math.max(y1, y2);
    } else {
      result.push(new Pair(x1, y1));
    }
  }
  return result;
};

// Tests
let v = [new Pair(1, 5), new Pair(3, 7), new Pair(4, 6), 
         new Pair(6, 8), new Pair(10, 12), new Pair(11, 15)];

let result = mergeIntervals(v)

let result_str = ""
for (let i = 0; i < result.length; i++){
  result_str = result_str + "[" + result[i].first + ", " + result[i].second + "] "
}
console.log(result_str)


let arr = [
  new Pair(1, 5),
  new Pair(3, 7),
  new Pair(4, 6),
  new Pair(6, 8),
  new Pair(10, 12),
  new Pair(11, 15),
];
// arr[0]["first"] -> 1

console.log(mergeIntervals(arr)); // [1, 8] [10, 15]
