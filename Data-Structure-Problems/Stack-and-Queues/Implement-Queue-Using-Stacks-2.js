/**
 * Implement a queue using stacks.
 */

/**
 * Intialize:
 * stack1, stack2
 * 
 * Steps:
 * 
 * enqueue(): O(1)
 *  always push on stack1
 * dequeue(): O(n)
 *  if queue size is 0, 
 *    return -1
 *  if stack2 has element(s), 
 *    pop the topmost and return.
 *  otherwise if stack1 is non empty, 
 *  pop all elements from stack1 and push them in stack2.
 *  at the end pop stack2 top most element and return.
 */

/**
 * Runtime Complexity: O(n)
 * Memory Complexity: O(n)
 */

class QueueUsingStack {
  constructor() {
    this.stack1 = [];
    this.stack2 = [];
  }

  enqueue(data) {
    this.stack1.push(data);
  }
  
  is_empty() {
    return (this.stack1.length === 0 && this.stack2.length === 0);
  }
  dequeue() {
    if (this.is_empty()) {
      return -1;
    }

    if (this.stack2.length === 0) {
      while (this.stack1.length !== 0) {
        this.stack2.push(this.stack1.pop());
      }
    }
    return this.stack2.pop();
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