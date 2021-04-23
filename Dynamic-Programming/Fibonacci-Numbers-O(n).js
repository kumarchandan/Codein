/**
 * Find the nth Fibonacci number in the Fibonacci sequence.
 */

 /**
  * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
  */
/**
 * first = 0
 * second = 1
 * next = first + second
 * count = 2 (already have 2 numbers determined, start from 3rd)
 * 
 * while count >= num:
 *  next = first + second
 *  first = second
 *  second = next
 *  count++ 
 * 
 * return next
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
