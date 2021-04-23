/** 
 * Given a dictionary of words and an input string tell 
 * whether the input string can be completely segmented into dictionary words.
*/

/** 
 * Runtime Complexity: exponential O(2^n)
 * With memoization, the runtime complexity of this solution can be improved to be polynomial, O(n^2).
 * 
 * Memory Complexity: Polynomial O(n^2)
 * As we create a substring on each recursion call. Creating a substring can be avoided if we pass indices.
*/

let canSegmentString = function(s, dictionary) {
  
  for (let i = 1; i < s.length + 1; i++) {

    let first = s.substr(0, i);

    if (dictionary.has(first)) {
      // found the first part, now check for second part using recursion
      // if second part is not found, then come back, continue with for loop, increase character in the first part
      // and repeat the same
      let second = s.substr(i);
      if (second.length === 0) {
        return true;
      }
      if (dictionary.has(second)) {
        return true;
      }
      if (canSegmentString(second, dictionary)) {
        return true;
      }
    }
  }
  return false;
};


let dictionary = new Set(["hello", "hell", "on", "now"]);
console.log(canSegmentString('hellonow', dictionary)) // true

// let alphaBSet = new Set(["aaaa","aaa"]);
// console.log(canSegmentString('aaaaaaa', alphaBSet)) // true

// BELOW EXAMPLE TAKES TOO MUCH TIME AND MEMORY, MIGHT HAVE TO USE MEMOIZATION
// let s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
// let dictionary = new Set(["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"])
// console.log('Result came:', canSegmentString(s, dictionary)); //

// let fruitSet = new Set(['pie', 'pear', 'apple', 'peach' ]);
// console.log(canSegmentString('applepie', fruitSet)) // true
// console.log(canSegmentString('applepeer', fruitSet)) // false


// let animalSet = new Set(["cats","dog","sand","and","cat"]);
// let animalArr = ["cats","dog","sand","and","cat"];
// console.log(canSegmentString('catsandog', animalSet)) // false

