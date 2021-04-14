let findMaxSlidingWindow = function(arr, window_size) {
  var result = [];
  //Write your code
  let p1 = 0;
  let p2 = window_size - 1;
  let len = arr.length;
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
// console.log(findMaxSlidingWindow([-4, 2, -5, 3, 6], 3))
// [2, 3, 6]
console.log(findMaxSlidingWindow([1,2,3,4,3,2,1,2,5],4))
// [4, 4, 4, 4, 3, 5]

// Runtime complexity
// O (m*n)  = for_loop * while_loop
