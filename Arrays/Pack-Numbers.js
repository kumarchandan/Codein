/**
 * Given an array of integers, pack neighboring numbers that are the same into the string X:N,
 * where X is the integer value and N is the sequence length
 * 
 * Input: [5,5,5,7,7,3,4,7]
 * Output: ['5:3', '7:2', 3, 4, 7]
 */
/**
 * Runtime Complexity: O(n)
 * Space Complexity: O(n)
 */
function packNumbers(arr) {
    let res = [];
    let count = 1;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] === arr[i+1]) {
            count++;
        } else {
            // If count is greater than 1, make a string otherwise just push the element
            // Get the default count into obj before resetting it
            if (count > 1) {
                res.push(`${arr[i]}:${count}`)
            }
            if (count === 1) {
                res.push(arr[i]);
            }
            // Reset count
            count = 1;
        }
    }
    return res;
}

// 
console.log(packNumbers([5,5,5,7,7,3,4,7])); // ['5:3', '7:2', 3, 4, 7]