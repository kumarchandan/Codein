/**
 * Given a string, check whether or not it is a palindrome
 * 
 * Input: "madam"
 * Output: true
 */

/**
 * Think in Recursion
 * input -> str = 'madam'
 * 
 * Recursive Case:
 * Compare first and last letter of str
 *  If same, Trim str from both sides, Send this new substring to recursive fn
 *  Else, return false
 * 
 * Base Case:
 * If length of str becomes 0 or 1 eventually, return true
 * 
 */

function isPalindrome(str) {
    // base case
    if (str.length <= 1) {
        return true;
    }
    // recursive case
    if (str[0] === str[str.length - 1]) {
        return isPalindrome(str.substring(1, str.length - 1));
    }
    return false;
}

console.log(isPalindrome('madam')); // true
