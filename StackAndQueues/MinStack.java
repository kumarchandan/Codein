package StackAndQueues;

/**
 * Can you create a stack where min() method gives minimum value in O(1) time?
 * Implement a new kind of stack called MinStack, which can get the minimum value in O(1) time.
 * 
 * Note: MinStack only deals with integer type values.
 * 
 */

public class MinStack {
    int maxSize;
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MinStack(int maxSize) {
        // We will use two stacks mainStack to hold original values
        // and minStack to hold minimum values. Top of minStack will always
        // be the minimum value from mainStack
        this.maxSize = maxSize;
        mainStack = new Stack<>(maxSize);
        minStack = new Stack<>(maxSize);
    }
    // removes and returns value from stack
    public int pop(){
        // 1. Pop element from minStack to make it sync with mainStack,
        // 2. Pop element from mainStack and return that value
        minStack.pop();
        return mainStack.pop();
    }
    // pushes value into the stack
    public void push(Integer value){
        // 1. Push value in mainStack and check value with the top value of minStack
        // 2. If value is greater than top, then push top in minStack
        //    else push value in minStack
        mainStack.push(value);
        
        if(!minStack.isEmpty() && minStack.top() < value) {
            minStack.push(minStack.top());
        } else {
            minStack.push(value);
        }
    }
    // returns minimum value in O(1)
    public int min(){
        return minStack.top();
    }

    public static void main(String args[]) {

        MinStack stack = new MinStack(6);
        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(9);
    
        System.out.println(stack.min());
    
        stack.pop();
        stack.pop();
        stack.pop();
    
        System.out.println(stack.min());
    }
}

// public class MinStack {
//     int maxSize;
//     int minValue;
//     Stack<Integer> stack;
    
//     //constructor
//     public MinStack(int maxSize) {
//         this.maxSize = maxSize;
//         stack = new Stack<Integer>(maxSize);
//     }
//     //removes and returns value from stack
//     public Integer pop(){
//         int value = stack.pop();
//         if (value == minValue) {
//             if(stack.isEmpty()) {
//                 minValue = -1;
//             } else {
//                 minValue = stack.top();
//             }
//         }
//         return value;
//     }
//     //pushes value into the stack
//     public void push(Integer value){
//         stack.push(value);
//         if (value < stack.top()) {
//             minValue = value;
//         }
//     }
//     //returns minimum value in O(1)
//     public int min(){
//         return minValue;
//     }
// }
