/**
 * Given an array, return an array where each index stores the product of all 
 * numbers in the array except the number at the index itself.
 * 
 * Input: arr = [1,2,3,4]
 * Output: arr = [24,12,8,6]
 * 
 * Input: arr = [4,2,1,5,0]
 * Output: arr = [0,0,0,0,40]
 */
/**
 * Runtime: O(n^2)
 * Memory: O(n) : res stores product
 */
function findProduct(arr) {
    let res = [];
    
    for(let i in arr) {
        let product = 1;
        let j = 0;
        while (j < arr.length) {
            if (i == j) {
                j++;
                continue;
            } else {
                product *= arr[j];
                j++;
            }
        }
        res.push(product);
    }
    return res;
}

// Tests
console.log(findProduct([1,2,3,4])); // [24,12,8,6]
