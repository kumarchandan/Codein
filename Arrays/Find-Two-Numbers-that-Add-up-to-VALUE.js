/**
 * Given an array and a number "value", find two numbers from the array that sum to 'value'
 * 
 * Input
 * arr = [1,21,3,14,5,60,7,6]
 * value = 81
 * 
 * Output
 * arr = [21,60]
 */
/**
 * Traverse the array with two pointers
 * one pointer starts from beginnig and the other from the end
 * Keep Incrementing first pointer and decrementing other until sum is found or entire array is traversed
 * 
 * Runtime: Linear O(n): Traversing the array once in worst case
 * Memory: Constant O(2)
 */
function findSum(arr, value) {
    let i = 0;
    let j = arr.length;
    let res = [];

    while(i < j) {
        if((arr[i] + arr[j]) === value) {
            res.push(arr[i]);
            res.push(arr[j]);
            break;
        }
        if (arr[i] < arr[j]) {
            i++;
        } else {
            j--;
        }
    }

    if(res.length === 2) {
        return res;
    } else {
        return false;
    }
    return res;
}

// Tests
console.log(findSum([1,21,3,14,5,60,7,6], 81)); // [21, 60]
console.log(findSum([1,2,3], 5)); // [2, 3]
console.log(findSum([1,2,3,4], 10)); // false