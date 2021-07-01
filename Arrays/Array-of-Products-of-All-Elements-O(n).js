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
 * Mathematically
 * 
 * Calculate the sum of entire array elements
 * Traverse array, and divide whole array product by each indices value 
 * 
 * Runtime: Linear O(n) - Traverses the array once to calculate totalProduct and then for division
 * Memory: Linear O(n) - Holds product at all indices
 */
function findProduct(arr) {
    let totalProduct = arr.reduce((prevElem, currElem) => prevElem * currElem, 1);
    let res = arr.map(elem => totalProduct / elem);
    return res;
}

// Tests
console.log(findProduct([1,2,3,4])); // [24,12,8,6]
console.log(findProduct([4,2,1,5,0])); // [0,0,0,0,40] -> [0,0,0,0,Nan] Doesn't work
console.log(findProduct([4,2,0,5,0]));
