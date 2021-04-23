/**
Runtime complexity #
The runtime complexity of this solution is logarithmic, O(log n).

Memory complexity #
The memory complexity of this solution is constant, O(1).
*/

let binarySearchRotated = function(arr, key) {

    let start = 0;
    let end = arr.length - 1;
  
    if (start > end){
      return -1;
    }
  
    while (start <= end){
      let mid = start + Math.floor((end - start) / 2);
  
      if (arr[mid] == key){
        return mid;
      }
  
      if (
        arr[start] <= arr[mid] && // if first half is sorted
        key <= arr[mid] && // if key is smaller than mid_value
        key >= arr[start] // if key is greater than start_value
      ) {
        end = mid - 1; // bring end towards first half
      }
      
      else if (
        arr[mid] <= arr[end] && // if second half is sorted
        key >= arr[mid] && // if key is greater than mid_value
        key <= arr[end] // if key is smaller than end_value
      ) {
        start = mid + 1; // bring start towards second half
      }
  
      else if (arr[end] <= arr[mid]) { // if end_value is less than mid_value
        start = mid + 1; // bring start towards second half
      }
  
      else if (arr[start] >= arr[mid]) { // if start_value is greater than mid_value
        end = mid - 1; // bring end towards first half
      }
      
      else {
        return -1;
      }
    }
    return -1;
  };
  
  // let v1 = [6, 7, 1, 2, 3, 4, 5];
    
  // console.log("Key(3) found at: " + binarySearchRotated(v1, 3));
  // console.log("Key(6) found at: " + binarySearchRotated(v1, 6));
      
  let v2 = [4, 5, 6, 1, 2, 3];
    
  console.log("Key(3) found at: " + binarySearchRotated(v2, 3));
  console.log("Key(6) found at: " + binarySearchRotated(v2, 6));
