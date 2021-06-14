'use strict';

module.exports = class Stack {

    constructor() {
        this.items = [];
        this.top = null;
    }

    isEmpty() {
        return this.items.length === 0;
    }

    getTop() {
        return this.top;
    }

    size() {
        return this.items.length;
    }

    push(element) {
        this.items.push(element);
        this.top = element;
        return this.size();
    }

    pop() {
        if (this.size() !== 0) {
            if (this.size() === 1) {
                this.top = null;
                return this.items.pop();
            } else {
                this.top = this.items[this.size() - 2];
                return this.items.pop();
            }
        } else {
            return null;
        }
    }
}

// UNDO module.exports to use the below code
// var myStack = new Stack();

// for (let i = 0; i < 5; i++) {
//     myStack.push(i);
// }

// console.log("Is stack empty? " + myStack.isEmpty());
// console.log("top: " + myStack.getTop());

// for (let i = 0; i < 5; i++) {
//     console.log('Element poppped: ', myStack.pop());
//     console.log('top: ', myStack.getTop()); 
// }

// console.log("Is stack empty?: " + myStack.isEmpty());
// console.log("top: " + myStack.getTop());
