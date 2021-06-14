/**
 * Implement a queue using stacks.
 */

/**
 * Intialize:
 * stack1, stack2
 * 
 * Steps:
 * enqueue(): O(n)
 *  pop each element from stack1 and push it to stack2.
 *  push item being enqueued to stack1.
 *  pop each element back from stack2 and push it to stack1.
 * 
 * dequeue(): O(1)
 * if queue size is 0, 
 *  return -1
 * 
 * pop from stack1 and return.
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

  enqueue(data) {

    while (this.stack1.length !== 0) {
      this.stack2.push(this.stack1.pop());
    }
    this.stack1.push(data);

    while (this.stack2.length !== 0) {
      this.stack1.push(this.stack2.pop());
    }
  }
  isEmpty() {
    return (this.stack1.length === 0 && this.stack2.length === 0);
  }

  dequeue() {
    if (this.isEmpty()) {
      return -1;
    }
    return this.stack1.pop();
  }
}
  
let qs = new QueueUsingStack();
console.log("dequeue()" + " = " + qs.dequeue())
qs.enqueue(3)
qs.enqueue(6)
qs.enqueue(16)
console.log("dequeue()" + " = " + qs.dequeue())
qs.enqueue(8);
qs.enqueue(4);
console.log("dequeue()" + " = " + qs.dequeue())