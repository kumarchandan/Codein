/**
 * The given array is sorted in ascending order.
 * Arrange elements in such a way that the maximum element appears at first, 
 * then minimum at second, then second maximum at third position and second minimum at fourth, and so on.
 * 
 * arr = [1,2,3,4,5]
 * arr = [5,1,4,2,3]
 */
/**
 * This solution is very smart. We store two elements at one index mathematically.
 * The original element is stored as the remainder, while the max/min element is stored as the multiplier. 
 * The following line achieves this;
 *      arr[i] += (arr[maxIdx] % maxElem ) * maxElem;
 * Here, arr[maxId] is stored as the multiplier. Whereas, arr[i] is stored as the remainder.
 */
 function maxMin(arr) {
    var maxIdx = arr.length-1
    var minIdx = 0
    // store any element that is greater than the maximum element in the array 
    var maxElem = arr[maxIdx] + 1;
    for( var i = 0; i < (arr.length); i++) {
      // at even indices we will store maximum elements
      if (i % 2 == 0){  
        arr[i] += Math.floor((arr[maxIdx] % maxElem ) * maxElem)
        maxIdx -= 1
      }
      else { // at odd indices we will store minimum elements
        arr[i] += Math.floor((arr[minIdx] % maxElem ) * maxElem)
        minIdx += 1
      }
    }
    // dividing with maxElem to get original values.
    for( var i = 0; i < (arr.length); i++) {
      arr[i] = Math.floor(arr[i] / maxElem)
    }
    return arr
}

// Tests
console.log(maxMin([1,2,3,4,5])); // [5,1,4,2,3]
console.log(maxMin([1,2,3,4,5,6,7,8,9])); // [ 9, 1, 8, 2, 7, 3, 6, 4, 5 ]
