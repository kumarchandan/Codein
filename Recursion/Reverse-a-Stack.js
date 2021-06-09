const Stack = require('./stack.js');

function insertAtBottom(stack, item) {
    // Base Case
    if (stack.isEmpty() === true) {
        stack.push(item);
    } else { // Recursive Case
        const temp = stack.pop();
        insertAtBottom(stack, item);
        stack.push(temp);
    }
}

function reverseStack(stack) {
    if (stack.isEmpty() === false) {
        const temp = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, temp);
    }
}


// Tests
const myStack = new Stack();
myStack.push(2);
myStack.push(3);
myStack.push(5);
myStack.push(8);

console.log('Original Stack: ');
console.log(myStack.getStack());

reverseStack(myStack);

console.log('Reversed Stack: ');
console.log(myStack.getStack());