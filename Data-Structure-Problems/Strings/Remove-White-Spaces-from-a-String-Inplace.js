/** 
 * Given a null terminated string, remove any white spaces (tabs or spaces).
 * "All greek to me."" should be "Allgreektome."
*/


let replaceAt = function(str, index, char) {
  // str.substr(0, index): characters from begining till writeIndex, 'All'
  // char: character to be added, 'g'
  // str.substr(index + char.length): characters starting from (writeIndex + character to be added length), 'greek to me.'
  // "All greek to me." -> "Allggreek to me." 
  return str.substr(0, index) + char + str.substr(index + char.length);
}

let removeWhiteSpaces = function(s) {
  if (!s || s.length === 0) {
    return;
  }

  let writeIndex = 0;
  let readIndex = 0;

  while (readIndex < s.length) {
    if (s[readIndex] !== ' ' && s[readIndex] !== '\t') {
      // Take the current str, write current char (readIndex is pointing to) to the space (where writeIndex is pointing currently)
      s = replaceAt(s, writeIndex, s[readIndex]);
      writeIndex++;
    }
    readIndex++;
  }
  return s.substr(0, writeIndex);
};

console.log(removeWhiteSpaces('All greek to me.')) // Allgreektome.
