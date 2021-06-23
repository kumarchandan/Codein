/**
 * Find Combinations for Game Scoring
 * 
 * Imagine a game where a player can score 1,2, or 4 runs.
 * Given a score, n, find the total number of ways to score n runs.
 * 
 * For example, to score 3 runs, a player can score in the following 3 ways:
 * (1 1 1)
 * (1 2)
 * (2 1)
 * 
 * To score 5 runs, a player can score the following 10 ways:
 * (1 1 1 1 1)
 * .
 * .
 * (4 1)
 */

/**
 * Use Fibonacci numbers.
 * Use the memoization technique.
 * Use principles of dynamic programming.
 */

/**
 * Memoization:
 * An optimization technique used to make programs faster and improve 
 * their performance by storing the results of expensive function calls and returning 
 * the cached result when the same input occurs again. It saves the computed results 
 * for possible later reuse, rather than recomputing them.
 * 
 * 
 */

/**
 * Runtime Complexity: O(n)
 * Space Complexity: O(n), since the call is recursive
 */

 // Scoring options are: 1, 2, 4
let scoringOptionsRec = function(n, result) {
    if (n < 0) {
        return 0;
    }
    // If the result is already calculated and cached, return
    if (result[n] > 0) {
        return result[n];
    }

    // Memoize
    result[n] = scoringOptionsRec(n - 1, result) + scoringOptionsRec(n - 2, result) + scoringOptionsRec(n - 4, result);
    return result[n];
}

let scoringOptions = function(n) {
    if (n <= 0) {
        return 0;
    }

    let result = [];
    // Initialize all blocks with -1, to cache the results later
    for (let i = 0; i < n + 1; i++) {
        result[i] = -1;
    }

    // Make the 0th index 1 as it's results are already known
    result[0] = 1;

    scoringOptionsRec(n, result);

    return result[n];
}

// Tests
console.log(scoringOptions(3)); // 3
console.log(scoringOptions(4)); // 6
console.log(scoringOptions(5)); // 10

