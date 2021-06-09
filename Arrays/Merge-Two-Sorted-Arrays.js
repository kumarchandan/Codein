/**
 * Given two sorted arrays, merge them into one array that is sorted.
 * 
 * Input:
 * arr1 = [1,3,4,5]  
 * arr2 = [2,6,7,8]
 * 
 * Output:
 * arr = [1,2,3,4,5,6,7,8]
 */

/**
 * Runtime Complexity: O(m+n) -> m: Length of arr1, n: Length of arr2
 */

function mergeArrays(arr1, arr2) { // O(m+n)
    let res = [];
    let i = 0;
    let j = 0;

    while((i < arr1.length) && (j < arr2.length)) {
        if(arr1[i] < arr2[j]) {
            res.push(arr1[i]);
            i++;
        } else {
            res.push(arr2[j]);
            j++;
        }
    }

    // One of the array is exhausted
    // Put remainings of other array in the res
    if (i < arr1.length) {
        while(i < arr1.length) {
            res.push(arr1[i]);
            i++;
        }
    } else if (j < arr2.length) {
        while(j < arr2.length) {
            res.push(arr2[j]);
            j++;
        }
    }
    return res;
}

// Tests
console.log(mergeArrays([1,3,4,5],[2,6,7,8]));
console.log(mergeArrays([],[]));
console.log(mergeArrays([],[1,2,3,4,5]));
console.log(mergeArrays([1,4,45,63],[]));
console.log(mergeArrays([4,4,4,4,4,4,4],[4,4,4,4,4,4,4]));
console.log(mergeArrays([-133,-100,0,4],[-2000,2000]));
console.log('done')