/**
 * Remove duplicate characters from a string which is passed by reference.
 */

/** 
 * Runtime Complexity: Linear O(n)
 * Memory Complexity: Constant O(n)
*/
/** 
 * Stop writeIndex where duplicate char is found
 * readIndex carries on
 * When readIndex finds a unique char, Put it where writeIndex is point at (it's duplicate anyway)
 * So basically, we are collecting unique chars and placing it on the given string itself by overwriting 
 * the duplicate chars pointed by writeIndex
 * WoW
*/

let replaceAt = function(str, writeIndex, readIndexChar) {
  return str.substr(0, writeIndex) + readIndexChar + str.substr(writeIndex + readIndexChar.length);
}

let removeDuplicates = function(str) {
  let writeIndex = 0;
  let readIndex = 0;

  let hashSet = new Set([]);

  while (readIndex < str.length) {
    if (!hashSet.has(str[readIndex])) {
      hashSet.add(str[readIndex]);
      // write this unique character on top of a repeated character found earlier (stopped at write Index)
      str = replaceAt(str, writeIndex, str[readIndex]);
      writeIndex++;
    }
    readIndex++;
  }
  return str.substr(0, writeIndex);
};

console.log(removeDuplicates('dabbac')); // dabc
console.log(removeDuplicates('World Hello')); // World He
console.log(removeDuplicates('We love Javascript')); // We lovJascript
console.log(removeDuplicates('To be or not to be')); // To bernt
console.log(removeDuplicates('You are amazing')); // You aremzing


/** 
 * With Copy of string and Set()
*/
// let removeDuplicates = function(str) {
//   let strSet = new Set();
//   let res = '';
//   for (let i = 0; i < str.length; i++) {
//     strSet.add(str[i])
//   }
//   strSet.forEach(item => res += item);
//   return res;
// };

// // Tests
// console.log(removeDuplicates('We love Javascript')) // We lovJascript
