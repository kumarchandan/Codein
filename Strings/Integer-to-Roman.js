/**
 * https://leetcode.com/problems/integer-to-roman/
 * 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * Input: num = 3
 * Output: "III"
 * 
 * Input: num = 9
 * Output: "IX"
 * 
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * 
 * Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

 * Constraints:
 * 1 <= num <= 3999
 */

/**
 * Runtime complexity: O(1)
 * Memory complexity: O(1)
 */

/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
    let res = '';
    const ROMAN = ['M', 'CM', 'D', 'CD', 'C', 'XC', 'L', 'XL', 'X', 'IX', 'V', 'IV', 'I'];
    const DECIMAL = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
    let number = num;
    for (let i = 0; i < DECIMAL.length; i++) {
        const roman = ROMAN[i];
        const decimal = DECIMAL[i];
        while (number >= decimal) {
            res += roman;
            number -= decimal;
        }
    }
    return res;
};

//
console.log(intToRoman(3)); // 'III'
console.log(intToRoman(4)); // 'IV'
console.log(intToRoman(9)); // 'IX'
console.log(intToRoman(58)); // 'LVIII'
console.log(intToRoman(1994)); // 'MCMXCIV'
