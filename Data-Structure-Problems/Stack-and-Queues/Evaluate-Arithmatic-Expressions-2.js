/**
 * Runtime complexity: Linear, O(n).
 * Memory complexity: Linear, O(n).
 */

let isDivOrMul = function(ch) {
  return (ch === '*' || ch === '/');
};

let isOperator = function(c) {
  return (c === '+' || c === '-' || c === '*' || c === '/');
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

let evaluate = function(expr) {
  let operators = [];
  let operands = [];

  let op = 0;
  let prev = 0;

  let i = 0;
  let n = expr.length;
  while (i < n) {
    let ch = expr[i];
    if (ch === ' ' || ch === '\t') {
      i++;
      continue;
    }

    if (isOperator(ch)) {
      op = ch;
      operators.push(ch);
      i++;
    } else {
      let re = strToDouble(expr, i);
      let d = re.digit;
      i = re.index;

      if (isDivOrMul(op)) {
        operators.pop();
        operands.pop();
        prev = (op === '*') ? (prev * d) : (prev / d);
        operands.push(prev);
        op = 0;
      } else {
        operands.push(d);
        prev = d;
      }
    }
  }

  let t = (operands.length > 0) ? operands[0] : 0;
  i = 1;
  for (let k = 0; k < operators.length; k++) {
    let operator = operators[k];
    let operand = operands[i];
    t = (operator === '+') ? (t + operand) : (t - operand);
    i++;
  }
  return t;
};

console.log("evaluate(3+6*5-1/2.5) = " + evaluate("3+6*5-1/2.5"))