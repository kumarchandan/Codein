/**
 * Find the nth Fibonacci number in the Fibonacci sequence.
 */

 /**
  * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
  */

let getFibonacci = function(num) {
    if (num === 1 || num === 0) {
        return num;
    }
    return getFibonacci(num - 1) + getFibonacci(num - 2);
}

console.log(getFibonacci(4)); // 3
console.log(getFibonacci(6)); // 8
