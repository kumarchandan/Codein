/** 
 * Given a sentence (an array of characters), reverse the order of words.
 * The "Hello World" string reversed should be "World Hello"
 * "The quick brown fox jumped over the lazy dog." should be "dog. lazy the over jumped fox brown quick The"
*/

/** 
 * Runtime Complexity: Linear O(n)
 * Memory Complexity: O(n)
*/
let reverseWords = function(sentence) {
  let str = '';
  let end_idx = sentence.length;

  for (let i = sentence.length - 1; i >= 0; i--) {
    if (sentence[i] === ' ') {
      str += sentence.substring(i + 1, end_idx) + sentence[i];
      end_idx = i;
    } else {
      continue;
    }
  }
  return str + sentence.substring(0, end_idx);
}


// Tests
console.log(reverseWords('New World Order.')) // Order. World New
console.log(reverseWords('We love Javascript'))	// Javascript love We	
console.log(reverseWords('World Hello'))	// Hello World
console.log(reverseWords('To be or not to be'))	// be to not or be To	
console.log(reverseWords('You are amazing'))	// amazing are You	
