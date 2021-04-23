/**
 * Remove duplicate characters from a string which is passed by reference.
 */

/** 
 * Runtime Complexity: Linear O(n^2)
 * Memory Complexity: Constant O(1)
*/
/** 
 * Stop writeIndex where duplicate char is found
 * readIndex carries on
 * When readIndex finds a unique char, Put it where writeIndex is point at (it's duplicate anyway)
 * So basically, we are collecting unique chars and placing it on the given string itself by overwriting 
 * the duplicate chars pointed by writeIndex
 * WoW
*/

let replaceAt = function(string, index, character) {
  return string.substr(0, index) + character + string.substr(index + character.length);
}

let removeDuplicates = function(str) {
  let writeIndex = 0;

  for (let i = 0; i < str.length; i++) {
    let found = false;

    for (let j = 0; j < writeIndex; j++) {
      if (str[i] === str[j]) {
        found = true;
        break;
      }
    }

    if (!found) {
      str = replaceAt(str, writeIndex, str[i]);
      writeIndex++;
    }
  }
  return str.substr(0, writeIndex);
};

console.log("Before: ", "dabbac");
console.log("After: ", removeDuplicates("dabbac")); // dabc

console.log(removeDuplicates('World Hello')); // World He
console.log(removeDuplicates('We love Javascript')); // We lovJascript
console.log(removeDuplicates('To be or not to be')); // To bernt
console.log(removeDuplicates('You are amazing')); // You aremzing
