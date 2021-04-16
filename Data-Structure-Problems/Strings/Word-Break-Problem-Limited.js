/** 
 * Given a dictionary of words and an input string tell 
 * whether the input string can be completely segmented into dictionary words.
*/

let canSegmentString = function(s, dictionary) {
    if (!s || s.length === 0) {
      return;
    }
  
    let start = 0;
    let end = 0;
  
    while (end <= s.length) {
      if (dictionary.has(s.substring(start, end))) {
        start = end;
      }
      end++;
    }
  
    if (start === (end - 1)) {
      return true;
    } else {
      return false;
    }
  };

// let fruitSet = new Set(['pie', 'pear', 'apple', 'peach' ]);
// console.log(canSegmentString('applepie', fruitSet)) // true
// console.log(canSegmentString('applepeer', fruitSet)) // false


// let animalSet = new Set(["cats","dog","sand","and","cat"]);
// let animalArr = ["cats","dog","sand","and","cat"];
// console.log(canSegmentString('catsandog', animalSet)) // false

// DOES NOT WORK WITH THIS INPUT
let alphaBSet = new Set(["aaaa","aaa"]);
console.log(canSegmentString('aaaaaaa', alphaBSet)) // true
