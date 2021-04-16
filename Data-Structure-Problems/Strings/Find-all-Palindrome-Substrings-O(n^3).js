/** 
 * Write an algorithm that returns the number of palindromes formed by all non single-letter substrings of an input string.
 * Input: aabbbaa
 * Output: aa bb bbb abbba aabbbaa bb aa
*/
/** 
 * Runtime Complexity: Polynomial O(n^3)
 * Memory Complexity: Constant  O(1)
*/

/**
 * A naive solution of this problem is to find all substrings of a given string and 
 * check whether each substring is a palindrome or not. This solution has a complexity of O(n^3)
 */

// pick a character from both ends and compare
let isPalindrome = function(input, i, j) {
  while(j > i) {
    if (input[i] !== input[j]) {
      return false;
    }
    i++;
    j--;
  }
  return true;
}

let findAllPalindromeSubstrings = function(input) {

  let count = 0;

  for (let i = 0; i < input.length; i++) {
    for (let j = (i + 1); j < input.length; j++) {
      if (isPalindrome(input, i, j)) {
        console.log(input.substring(i, j + 1));
        count++;
      }
    }
  }
  return count;
}

// Tests
console.log('Total palindromes found: ', findAllPalindromeSubstrings('aabbbaa'));
