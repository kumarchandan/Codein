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
 * Push Operation: O(n)
 * if queue1 is empty:
 *  then enqueue in queue1
 * otherwise,
 *  enqueue in queue2 and dequeue all elements from queue1 and push them on queue2
 *  then swap the queue references
 * 
 * Pop Operation: O(1)
 * if stack size is 0:
 *  return -1
 * dequeue from queue1 and return
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
        return this.queue1.length;
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

        while (this.size() > 1) {
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
