/**
 * Implement a stack using queues.
 */

 /**
  * Runtime Complexity: O(n)
  * Memory Complexity: O(1)
  */

/**
 * Initalize:
 * queue1, queue2
 * 
 * Steps:
 * Push Operation: O(1)
 * enqueue in queue1
 * 
 * Pop Operation: O(n)
 * dequeue elements from queue1 leaving last element to queue2
 * dequeue the last element from queue1 and return
 * Swap the reference of queue1 and queue2 (queue2 should be new queue1 and vice versa)
 */


class StackUsingQueue {

    constructor() {
        this.queue1 = [];
        this.queue2 = [];
    }

    isEmpty() {
        return ((this.queue1.length + this.queue2.length) === 0);
    }

    size() {
        return this.queue1.length + this.queue2.length;
    }

    swapQueues() {
        let temp = this.queue1;
        this.queue1 = this.queue2;
        this.queue2 = temp;
    }

    push(data) {
        return this.queue1.push(data);
    }

    pop() {
        if (this.isEmpty()) {
            return -1;
        }

        while (this.queue1.length > 1) {
            this.queue2.push(this.queue1.shift()); // shift() -> works like dequeue, push() -> works like enqueue
        }

        let result = this.queue1.shift();
        // swap
        this.swapQueues();
        return result;
    }
}

let sq = new StackUsingQueue();

for (let i = 0; i < 5; i++) {
    console.log('Pushing elements: new size ', sq.push(i));
}

for (let i = 0; i < 6; i++) {
    console.log('Popping elements: ', sq.pop());
}
