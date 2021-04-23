/**
 * Given two strings ‘s1’ and ‘s2’, find the length of the longest substring which is common in both the strings.
 * 
 * Input: s1 = "passport"
 *        s2 = "ppsspt"
 * Output: 3
 * Explanation: The longest common substring is "ssp".
 */

/**
 * A brute force solution: try all substrings of 's1' and 's2' to find the longest common one
 * If the strings have a matching character, we can recursively match for the remaining lengths and 
 * keep a track of the current matching length.
 * If the strings don’t match, we start two new recursive calls by skipping one character separately 
 * from each string and reset the matching length.
 * 
 * The length of the Longest Common Substring (LCS) will be the maximum number returned by the three 
 * recurse calls in the above two options.
 */

const findLCSLength = function(s1, s2) {
    function findLCSLengthRecursive(s1, s2, i1, i2, count) {
        if (i1 === s1.length || i2 === s2.length) {
            return count;
        }

        if (s1[i1] === s2[i2]) {
            count = findLCSLengthRecursive(s1, s2, i1 + 1, i2 + 1, count + 1);
        }

        const c1 = findLCSLengthRecursive(s1, s2, i1, i2 + 1, 0);
        const c2 = findLCSLengthRecursive(s1, s2, i1 + 1, i2, 0);

        return Math.max(count, Math.max(c1, c2));
    }
    return findLCSLengthRecursive(s1, s2, 0, 0, 0);
}

console.log(`Length of Longest Common Substring: ---> ${findLCSLength('abdca', 'cbda')}`); // bd : 2
console.log(`Length of Longest Common Substring: ---> ${findLCSLength('passport', 'ppsspt')}`); // ssp : 3
