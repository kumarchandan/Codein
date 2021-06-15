'use strict'
/**
 * Reverse the first "k" elements in a given queue
 * 
 * Implement the function reverseK(queue, k), which takes a queue and a number “k” as input and 
 * reverses the first “k” elements of the queue.
 * Input: A queue and an integer k such that 0 ≤ k ≤ size of the queue
 */

/**
 * Steps:
 * Dequeue k elements from the queue and push them to a Stack
 * Pop the stack one by one and enqueue them
 * Now dequeue (queueSize - k) elments and enqueue them at the same time
 */

/**
 * Runtime Complexity: O(n)
 * 
 * Overall, k elements are dequeued, pushed to the stack, popped from it, and then enqueued.
 * Additionally, n−k elements are dequeued and enqueued to the queue. On the assumption that 
 * each push, pop, enqueue or dequeue operation takes constant time, the time complexity of this 
 * function is O(n) as all nn elements have to be processed with constant-time​ operations.
 * Memory Complexity: 
 */

const Queue = require('./Queue');
const Stack = require('./Stack');

let reverseK = function(queue, k) {

    if(!queue || queue.size() < 3) {
        return null;
    }

    let count = 0;
    let stack = new Stack();

    while (count < k) {
        stack.push(queue.dequeue()); // O(1) + O(n)
        count++;
    }

    // enqueue reversed numbers as it's popped from stack
    while (!stack.isEmpty()) {
        queue.enqueue(stack.pop()); // O(1) + O(1)
    }

    // dequeue the first (queue.size - k) elements and enqueue them back
    let limit = queue.size() - k;
    count = 0;
    while (count < limit) {
        queue.enqueue(queue.dequeue()); // O(1) + O(n)
        count++;
    }

    return queue;
}

// Tests
var queue = new Queue()
queue.enqueue(1)
queue.enqueue(2)
queue.enqueue(3)
queue.enqueue(4)
queue.enqueue(5)
queue.enqueue(6)
queue.enqueue(7)
queue.enqueue(8)
queue.enqueue(9)
queue.enqueue(10)

reverseK(queue,5)

let queueSize = queue.size();

// Results
// 5,4,3,2,1,6,7,8,9,10
for(var i = 0; i < queueSize; i++) {
    console.log(queue.dequeue());
}
