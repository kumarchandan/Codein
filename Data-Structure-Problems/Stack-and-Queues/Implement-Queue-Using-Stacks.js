/**
 * Implement a queue using stacks.
 */

/**
 * Intialize:
 * stack1, stack2
 * 
 * Steps:
 * Enqueue Operation: O(1)
 *  Push new data in stack1
 * 
 * Dequeue Operation:
 *  Pop all data from stack1 to stack2 - Pop once from stack2 and return it
 *  refill stack1
 */
/**
 * Runtime Complexity: O(n)
 * Memory Complexity: O(1)
 */

class QueueUsingStack {

    constructor() {
        this.stack1 = [];
        this.stack2 = [];
    }

    isEmpty() {
        return ((this.stack1.length + this.stack2.length) === 0);
    }

    size() {
        return this.stack1.length + this.stack2.length;
    }

    refillStack() { // O(n)
        while(this.stack2.length > 0) {
            this.stack1.push(this.stack2.pop());
        }
    }

    enqueue(data) {
        return this.stack1.push(data); // return length of stack
    }

    dequeue() {
        if (this.size() === 0) {
            return -1;
        }
        let res = -1;
        if(this.stack2.length > 0) {
            res = this.stack2.pop();
            return res;
        } else if (this.stack1.length > 0) {
            while(this.stack1.length > 0) { // O(n)
                this.stack2.push(this.stack1.pop());
            }
        }
        

        let res = this.stack2.pop();
        // refill stack1
        this.refillStack();
        return res;
    }
}

// Tests
let queue = new QueueUsingStack();
console.log('enqueue 2: new length of queue: ', queue.enqueue(2));
console.log('enqueue 4: new length of queue: ', queue.enqueue(4));

console.log('Dequeue: ', queue.dequeue());
console.log('Dequeue: ', queue.dequeue());
console.log('Dequeue: ', queue.dequeue());
console.log('enqueue 6: new length of queue: ', queue.enqueue(6));
console.log('enqueue 8: new length of queue: ', queue.enqueue(8));

console.log('Dequeue: ', queue.dequeue());
console.log('Dequeue: ', queue.dequeue());
