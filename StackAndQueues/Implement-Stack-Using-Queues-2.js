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

  swap_queues() {
    let temp = this.queue1;
    this.queue1 = this.queue2;
    this.queue2 = temp;
  }

  push(data) {
    if (this.queue1.length === 0) {
      this.queue1.push(data);
    } else {
      this.queue2.push(data);
      while (this.queue1.length !== 0) {
        this.queue2.push(this.queue1.shift());
      }
      this.swap_queues();
    }
  }

  isEmpty() {
    return this.queue1.length + this.queue2.length === 0;
  }

  pop() {
    if (this.isEmpty()) {
      return -1;
    }
    return this.queue1.shift();
  }
}

let sq = new StackUsingQueue();
console.log("Pop(): " + sq.pop())
sq.push(3)
sq.push(5)
sq.push(9)
console.log("Pop(): " + sq.pop())
sq.push(10);
sq.push(16);
console.log("Pop(): " + sq.pop())
