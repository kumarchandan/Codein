/**
 * Given two strings ‘s1’ and ‘s2’, find the length of the longest substring which is common in both the strings.
 * 
 * Input: s1 = "passport"
 *        s2 = "ppsspt"
 * Output: 3
 * Explanation: The longest common substring is "ssp".
 */

/**
 * Bottom-up Dynamic Programming
 * Since we want to match all the substrings of the given two strings, we can use a two-dimensional array 
 * to store our results. The lengths of the two strings will define the size of the two dimensions of the array. 
 * So for every index ‘i’ in string ‘s1’ and ‘j’ in string ‘s2’, we have two options:
 * If the character at s1[i] matches s2[j], the length of the common substring would be one plus the length 
 * of the common substring till i-1 and j-1 indexes in the two strings.
 * If the character at the s1[i] does not match s2[j], we don’t have any common substring.
 */
/**
 * Runtime Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

const findLCSLength = function(s1, s2) {
    const dp = Array(s1.length + 1).fill(0).map(() => Array(s2.length + 1).fill(0));

    let maxLength = 0;
    for (let i = 1; i <= s1.length; i++) {
        for (let j = 1; j <= s2.length; j++) {
            if (s1.charAt(i - 1) === s2.charAt(j - 1)) {
                // If matches, Add it with previous data (go back diagonally) - diagonal creates
                dp[i][j] = 1 + dp[i - 1][j - 1];
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
    }
    return maxLength;
}

console.log(`Length of Longest Common Substring: ---> ${findLCSLength('abdca', 'cbda')}`); // bd : 2
console.log(`Length of Longest Common Substring: ---> ${findLCSLength('passport', 'ppsspt')}`); // ssp : 3
