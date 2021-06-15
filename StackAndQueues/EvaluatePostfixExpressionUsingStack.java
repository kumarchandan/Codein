package StackAndQueues;

/**
 * A stack1
 * 1) Traverse the string holding expression
 * 2) If numbers found, put them in the stack,
 * 3) If expression found
*       Pop two values from stack,
*       evaluate the expression (last popped becomes op1 and other one op2)
*       Put this value in stack
*       Continue from Step 1
 */
/**
 * Runtime: O(n) Linear : Traversing the string once
 */

public class EvaluatePostfixExpressionUsingStack {
    public static int evaluatePostfix(String str) {
        int result = Integer.MIN_VALUE;

        Stack<Integer> stack = new Stack<>(20);

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));
            } else {
                if (!stack.isEmpty()) {
                    int operand2 = stack.pop();
                    int operand1 = stack.pop();

                    // Perform arithmetic operation
                    if (ch == '*') {
                        result = operand1 * operand2;
                    } else if (ch == '+') {
                        result = operand1 + operand2;
                    } else if (ch == '-') {
                        result = operand1 - operand2;
                    } else if (ch == '/') {
                        result = operand1 / operand2;
                    }
                    // Push to stack
                    stack.push(result);
                } else {
                    return -1;
                }
                
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(EvaluatePostfixExpressionUsingStack.evaluatePostfix("921*-8-4+"));
    }
}
