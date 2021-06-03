/**
 * Given a decimal number, convert it to a binary number.
 * 
 * Input: 11
 * Output: 1011
 */

/**
 * Base Case:
 * If decNum <= 1 then return decNum (Either 1 or 0)
 * 
 * Recursive Case:
 * concat of fn(Math.floor(decNum / 2) and fn(decNum % 2)
 * 
 * 11                  // 1011
 * (11 / 2) + (11 % 2) // 101 1
 * (5 / 2) + (5 % 2)   // 10 1
 * (2 / 2) + (2 % 2)   // 1 0
 */
function decimalToBinary(decNum) {
    if (decNum <= 1) {
        return String(decNum); // returns 0 or 1
    } else {
        return decimalToBinary(Math.floor(decNum / 2)) +
                decimalToBinary(decNum % 2);
    }
}

// Tests
console.log(decimalToBinary(11)); // 1011
