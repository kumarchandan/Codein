/**
 * Runtime complexity: Linear, O(n).
 * Memory complexity: Linear, O(n).
 */

class Token {
  constructor(value, isOperator) {
    this.value = value;
    this.isOperator = isOperator;
  }
}

let isOperator = function(c) {
  return (c === '+' || c === '-' || c === '*' || c === '/');
};
// returns true if op1 has higher/equal precedence
// compared to op2
let preced = function(op1, op2) {
  if (op1 === '*' || op1 === '/') {
    return true;
  }

  if (op1 === '+' || op1 === '-') {
    if (op2 === '+' || op2 === '-') {
      return true;
    }
  }

  return false;
};

let isDigit = function(ch) {
  return (ch >= '0' && ch <= '9');
};

let strToDouble = function(s, i) {
  let n = s.length;
  if (i >= n) {
    return null;
  }

  let temp = '';
  while (i < n && (s[i] === ' ' || s[i] === '\t')) {
    i++;
  }

  if (i >= n) {
    return null;
  }

  if (s[i] === '-') {
    temp += '-';
    i++;
  }

  while (i < n) {
    let ch = s[i];
    if (ch !== '.' && !isDigit(ch)) {
      break;
    }

    temp += ch;
    i++;
  }

  return {
    digit: parseFloat(temp),
    index: i
  };
};

let convertToPostfix = function(expr) {
  let postFix = [];

  let operators = [];
  let n = expr.length;
  let i = 0;
  while (i < n) {
    let ch = expr[i];
    if (ch === ' ' || ch === '\t') {
      i++;
      continue;
    }

    if (isOperator(ch)) {
      while (operators && preced(operators[operators.length - 1], ch)) {
        let t = new Token(operators.pop(), true);
        postFix.push(t);
      }
      operators.push(ch);
      i++;
    } else {
      let re = strToDouble(expr, i);
      let d = re.digit;
      i = re.index;
      let t = new Token(d, false);
      postFix.push(t);
    }
  }
  while (operators.length > 0) {
    let t = new Token(operators.pop(), true);
    postFix.push(t);
  }
  return postFix;
};

let evaluate1 = function(postFix) {
  let operands = [];
  for (let x = 0; x < postFix.length; x++) {
    if (postFix[x].isOperator) {
      let val2 = operands.pop();
      let val1 = operands.pop();
      let op = postFix[x].value;
      if (op === '+') {
        operands.push(val1 + val2);
      } else if (op === '-') {
        operands.push(val1 - val2);
      } else if (op === '*') {
        operands.push(val1 * val2);
      } else if (op === '/') {
        operands.push(val1 / val2);
      }
    } else {
      operands.push(postFix[x].value);
    }
  }
  return operands.pop();
};

let evaluate = function(expr) {
  return evaluate1(convertToPostfix(expr));
};

console.log("evaluate(3+6*5-1/2.5) = " + evaluate("3+6*5-1/2.5"))