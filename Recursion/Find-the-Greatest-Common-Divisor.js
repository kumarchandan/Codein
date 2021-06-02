/**
 * Implement a function that takes two numbers, var1 and var2 and 
 * returns their greatest common divisor.
 * 
 * The Greatest Common Divisor of two or more integers is the largest positive integer that divides each of the integers.
 * 
 * For example, take two numbers 42 and 56.
 * 42 can be completely divided by 1, 2, 3, 6, 7, 14, 21 and 42.
 * 56 can be completely divided by 1, 2, 4, 7, 8, 14, 28 and 56.
 * 
 * Therefore, the greatest common divisor of 42 and 56 is 14.
 */
/**
 * Naive Approach:
 * - List all divisors
 * - Pick the common ones
 * - Return greatest
 */
/**
 * Mathematic approach:
 * The idea behind calculating GCDGCD is: If m>nm>n, GCD(m,n)GCD(m,n) is the same as GCD(m-n,n)GCD(m−n,n).

This is because if m/dm/d and n/dn/d both leave no remainder, then (m-n)/d(m−n)/d leaves no remainder, either.
 * gcd(m, n) = { 
 *              m           if m == n,
 *              gcd(m-n, n) if m > n,
 *              gcd(m, n-m) if m < n
 * }
 * 
 * Think in Recursion
 * 
 * Base Case:
 * if m == n then return m or n
 * 
 * Recursive Case:
 * if m > n then gcd(m-n, n)
 * if m < n then gcd(m, n-m)
 * 
 * Example: 42 and 56
 * gcd(42, 56)
 * 
 * m < n
 * gcd(42, 14)
 * 
 * m > n
 * gcd(28, 14)
 * 
 * m > n
 * gcd(14, 14)
 * 
 * m == n
 * return 14
 * 
 */
function gcd(var1, var2) {
    // Base case
    if (var1 === var2) {
        return var1;
    }

    // Recursive case
    if(var1 > var2) {
        return gcd(var1 - var2, var2);
    }

    if(var1 < var2) {
        return gcd(var1, var2 - var1);
    }
}

// Tests
console.log(gcd(42, 56)); // 14
console.log(gcd(6, 9)); // 3
console.log(gcd(7, 8)); // 1 --> by default gcd is 1 for any two numbers
