/**
 * Find the nth Fibonacci number in the Fibonacci sequence.
 */

 /**
  * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
  */
/**
 * first = 0
 * second = 1
 * sum = 0 + 1 = 1
 * count = 2
 * 
 * while count >= num:
 *  sum = first + second
 *  temp = second
 *  first = second
 *  first 
 */

let getFibonacci = function (num) {
  
    let first = 0;
    let second = 1;
    let count = 2;
    let next = 0;
    while (count <= num) {
        next = first + second;
        first = second;
        second = next;
        count++;
    }
    return second;
}

console.log(getFibonacci(4)); // 3
console.log(getFibonacci(6)); // 8
