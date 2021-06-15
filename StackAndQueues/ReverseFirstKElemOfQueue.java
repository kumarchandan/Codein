package StackAndQueues;

public class ReverseFirstKElemOfQueue {
    public static <V> void reverse(Queue<V> queue, int k) {
        // dequeue k elements and put them in a stack
        int count = 0;
        Stack<V> stack = new Stack<V>(k);
        while (stack.isFull() == false) {
            stack.push(queue.dequeue());
            count++;
        }
        // pop from stack and enqueue
        while (stack.isEmpty() == false) {
            queue.enqueue(stack.pop());
            count++;
        }
        // Again dequeue currentSize - k  and enqueue
        count = 0;
        while (count < queue.getCurrentSize() - k) {
            queue.enqueue(queue.dequeue());
            count++;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>(3);

        for (int i = 23; i < 28; i+=2) {
            queue.enqueue(i);
        }

        ReverseFirstKElemOfQueue.reverse(queue, 3);
        while(queue.isEmpty() == false) {
            System.out.println(queue.dequeue());
        }
    }
}
