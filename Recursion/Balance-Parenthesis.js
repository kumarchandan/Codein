/**
 * Given an array that contains opening and closing parentheses, check 
 * whether or not the opening and closing parentheses are balanced.
 */
/**
 * 
 * Closing parentheses match opening parentheses in the reverse order of their appearance, 
 * meaning that they match from the inside out. This is a clue that recursion can be used
 * 
 * Initialize
 * startIdx, currentIdx
 * 
 * startIdx: traverses the whole array. In each recursive call, it moves to the next element
 *          tells if reached to end of the arr
 * currentIdx: examines if each closing parenthesis has an opening
 *             If closing parenthesis found, decrease by 1
 *             If opening found, increase by 1
 *             If currentIdx !== 0 at the end of traversal, return false
 * 
 */

function balanced(arr, startIdx=0, currentIdx=0) {
    // Base Cases 1 and 2
    if (startIdx === arr.length) { // Base Case 1
        if (currentIdx === 0) {  // // Base Case 2
            return true;
        } else {
            return false;
        }
    }

    // Base Case 3
    if (currentIdx < 0) { // A closing parenthesis did not find its corresponding opening parenthesis
        return false;
    }

    // Recursive Cases
    if (arr[startIdx] === '(') { // Recursive Case 1
        return balanced(arr, startIdx + 1, currentIdx + 1);
    } else if (arr[startIdx] === ')') { // Recursive Case 2
        return balanced(arr, startIdx + 1, currentIdx - 1);
    } else {
        return false; // the string contained an unrecognized character
    }
}

// Tests
console.log(balanced(["(", "(", ")", ")", "(", ")"])); // true
console.log(balanced(["(", "(", ")"])); // false
