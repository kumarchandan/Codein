package StackAndQueues;
/**
 * Use 2 stacks.
 * 
 * For enqueue operation:
 * Put values in Stack1
 * 
 * For dequeue operation:
 * Pop all element from Stack1 and Push it to Stack2
 * Pop one element from Stack2 (that's dequeue return value)
 * 
 * Keeping popping stack2 for dequeue until it's empty
 * once stack2 is empty, fill it back with stack1
 * 
 */
public class QueueWithStack<V> {

    Stack<V> stack1;
    Stack<V> stack2;

    public QueueWithStack(int maxSize) {
        stack1 = new Stack<>(maxSize);
        stack2 = new Stack<>(maxSize);
    }

    public boolean isEmpty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }

    public void enqueue(V value) {
        stack1.push(value);
    }

    public V dequeue() {
        if (isEmpty()) {
            return null;
        }

        if (stack2.isEmpty()) {
            while(stack1.isEmpty() == false) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return stack2.pop();
        }
        
    }

    public static void main(String args[]) {
    
        QueueWithStack<Integer> queue = new QueueWithStack<Integer>(5);
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
      
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue()); //this will output null because queue will be empty
      }

    
}
