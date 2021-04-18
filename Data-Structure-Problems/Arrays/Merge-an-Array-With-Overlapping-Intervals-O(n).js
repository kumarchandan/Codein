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
  let result = [];

  if (!v && v.length < 2) {
    return result;
  }

  let pair = new Pair(v[0].first, v[0].second);
  let i = 0;
  while (i < v.length - 1) {
    if ((v[i].second >= v[i+1].first) || (v[i].second >= v[i+1].second)) {
      pair.second = v[i+1].second;
      i++;
    } else {
      result.push(pair);
      pair = new Pair(v[i+1].first, v[i+1].second);
      i++;
    }
  }
  result.push(pair);
  
  return result;
}

// Tests
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
