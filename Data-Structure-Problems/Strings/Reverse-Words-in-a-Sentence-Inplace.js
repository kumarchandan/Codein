/** 
 * Given a sentence (an array of characters), reverse the order of words.
 * The "Hello World" string reversed should be "World Hello"
 * "The quick brown fox jumped over the lazy dog." should be "dog. lazy the over jumped fox brown quick The"
*/

/** 
 * Runtime Complexity: Linear O(n)
 * Memory Complexity: O(1) : This solution reverses every word in-place, it doesn't require any extra space
*/
/** 
 * Steps:
 * Reverse the string.
 * Traverse the string and reverse each word in place.
*/
let strRev = function(str, start, end) {
  if (!str || str.length < 2) {
    return;
  }

  while (start < end) {
    let temp = str[start];
    str = str.substr(0, start) + str[end] + str.substr(start + str[end].length);
    str = str.substr(0, end) + temp + str.substr(end + temp.length);

    start++;
    end--;
  }

  return str;
};

let reverseWords = function(sentence) {

  // Here sentence is a null-terminated string ending with char '\0'.
  if (!sentence || sentence.length === 0) {
    return;
  }

  // To reverse all words in the string, we will first reverse
  // the string. Now all the words are in the desired location, but
  // in reverse order: "Hello World" -> "dlroW olleH".
  let strLen = sentence.length;
  sentence = strRev(sentence, 0, strLen - 1);

  // Now, let's iterate the sentence and reverse each word in place.
  // "dlroW olleH" -> "World Hello"
  let start = 0;
  let end = 0;
  
  while (true) {
    // find the  start index of a word while skipping spaces.
    while (sentence[start] === ' ') {
      start++;
    }
    if (start >= sentence.length) {
      break;
    }

    // find the end index of the word.
    end = start + 1;
    while (end < sentence.length && sentence[end] != ' ') {
      end++;
    }

    // let's reverse the word in-place.
    sentence = strRev(sentence, start, end - 1);

    start = end;
  }
  return sentence;
};

let stringToReverse1 = "Hello World!";
let stringToReverseResult1 = reverseWords(stringToReverse1);
let stringToReverseExpect1 = 'World! Hello';
console.log(stringToReverse1);
console.log(stringToReverseResult1);


// Tests
console.log(reverseWords('New World Order.')) // Order. World New
console.log(reverseWords('We love Javascript'))	// Javascript love We	
console.log(reverseWords('World Hello'))	// Hello World
console.log(reverseWords('To be or not to be'))	// be to not or be To	
console.log(reverseWords('You are amazing'))	// amazing are You	
