/** 
 * Write an algorithm that returns the number of palindromes formed by all non single-letter substrings of an input string.
 * Input: aabbbaa
 * Output: aa bb bbb abbba aabbbaa bb aa
*/
/** 
 * Runtime Complexity: Polynomial O(n^2)
 * Memory Complexity: Constant  O(1)
*/

/**
 * We can reduce the runtime complexity of this algorithm to O(n^2)
 * For each letter in the input string, start expanding to the left and right while checking 
 * for even and odd length palindromes. Move to the next letter if we know a palindrome doesn’t exist.
 * 
 * We expand one character to the left and right and compare them. If both of them are equal, we print out the
 * palindrome substring.
 */

// From the point, go one step left with j and one step right with k, if it matches (palindrome exists)
let findAllPalindromeInSubstrings = function(input, j, k) {
  let count = 0;
  while (j >= 0 && k < input.length) {
    if (input[j] !== input[k]) {
      break;
    }
    console.log(input.substring(j, k+1));
    count++;
    j--;
    k++;
  }
  return count;
}

let findAllPalindromeSubstrings = function(input) {
  let count = 0;
  for (let i = 0; i < input.length; i++) {
    // Start with one step left and one step right
    // Expand for Odd length palindrome
    count += findAllPalindromeInSubstrings(input, i - 1, i + 1);
    // Expand for Even length palindrome
    count += findAllPalindromeInSubstrings(input, i, i + 1);
  }
  return count;
};

// Tests
console.log('Total palindromes found: ', findAllPalindromeSubstrings('aabbbaa'));
