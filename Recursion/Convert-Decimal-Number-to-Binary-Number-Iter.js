/**
 * Given a decimal number, convert it to a binary number.
 * 
 * Input: 11
 * Output: 1011
 */

/**
 * Iterative way:
 * https://www.tutorialspoint.com/how-to-convert-decimal-to-binary
 * 
 * 11 % 2 = 1
 * 11 / 2 = 5
 * 
 * 5 % 2 = 1
 * 5 / 2 = 2
 * 
 * 2 % 2 = 0
 * 2 / 2 = 1
 * 
 * 1 % 2 = 1
 * 1 / 2 = 0
 * 
 * 11 -> 1011
 * 
 */
function decimalToBinary(decNum) {
    let res = [];
    while (decNum > 0) {
        res.push(decNum % 2);
        decNum = Math.floor(decNum / 2);
    }
    return res.reverse().join('');
}

// Tests
console.log(decimalToBinary(11)); // 1011
