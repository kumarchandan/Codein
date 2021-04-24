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

 // Scoring options are: 1, 2, 4
let scoringOptions = function(n) {
    if (n <= 0) {
        return 0;
    }

    // Max score is 4. Hence we need to save
    // last 4 ways to calculate the number of ways
    // for a given n
    // save the base case on last index of the vector
    let result = [0, 0, 0, 1];
    for (var i = 1; i < n + 1; i++) {
        let current_sum = result[3] + result[2] + result[0];
    
        //slide left all the results in each iteration
        //result for current i will be saved at last index
        result[0] = result[1];
        result[1] = result[2];
        result[2] = result[3];
        result[3] = current_sum;
    }
    return result[3];
}

// Tests
console.log(scoringOptions(3)); // 3
console.log(scoringOptions(4)); // 6
console.log(scoringOptions(5)); // 10

