package StackAndQueues;

/**
 * Can you implement a method to find the next greater element after any given element from the stack?
 * 
 * Input: arr = {4,6,3,2,8,1}
 * Output: result = {6,8,8,8,-1,-1}
 * 
 * The next greater element is the first element towards the right, which is greater than the current 
 * element. For example, in the array [1, 3, 8, 4, 10, 5], the next greater element of 3 is 8, and the 
 * next greater element for 8 is 10. To keep it simple, the next greater element for the last or maximum 
 * value in the array is -1.
 */

/**
 * Runtime: O(n)
 * In the above algorithm, it is observed that every element is pushed on the stack exactly once. Furthermore, 
 * since once an element is removed from the stack, it is never re-inserted, every element is removed exactly once, too.
 * we perform one push and one pop operation per element, exactly. 
 * Therefore, the time complexity of this algorithm will be O(n).
 * 
 * Memory: O(n) for stack of array input size
 */
public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>(arr.length);

        // Iterate over arr backwards
        for (int i = arr.length - 1; i >= 0; i--) {
            if(!stack.isEmpty()) {
                // Pop from the stack until get the greater element
                while(!stack.isEmpty() && stack.top() <= arr[i]) {
                    stack.pop();
                }
            }
            // If Stack becomes empty after popping, put -1 by default as greater element
            if (stack.isEmpty()) {
                result[i] = -1;
            } else { // Otherwise top is greater element
                result[i] = stack.top();
            }
            // Every new element is potential next greater element, So Keep it in stack
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,6,3,2,8,1};
        int[] result = NextGreaterElement.nextGreaterElement(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
