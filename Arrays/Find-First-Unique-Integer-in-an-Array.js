/**
 * Given an array, find the first integer, which is unique in the array.
 * 
 * Input: [9,2,3,2,6,6]
 * Output: 9
 */
/**
 * Traverse the array once
 * Keep storing new elemts in a Set
 * If duplicate found, delete it from Set
 * 
 * After traversal the arr will have unique values
 * Return the first one
 * 
 * Runtime: Linear O(n) - Traverses the array once
 * Memory: Linear O(n) - In a Worst case, Set can have all n values
 */
function findFirstUnique(arr) {
    let set = new Set();
 
    for (let val of arr) {
       // If duplicate value found, delete it from the Set
       if(set.has(val)) {
          set.delete(val);
       } else {
          set.add(val);
       }
    }
    // Set has only unique values, return the first value found
    if (set.size > 0) {
       let iter = set.values();
       return iter.next().value;
    } else {
       return false;
    }
}

// Tests
console.log(findFirstUnique(9,2,3,2,6,6)); // 9
console.log(findFirstUnique(4,5,1,2,0,4)); // 5