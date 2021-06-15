package StackAndQueues;

// Iterate through the string exp.
// For each opening parentheses, push it into stack
// For every closing parenthesis check for its opening parentheses in stack
// If you can't find the opening parentheses for any closing one then returns false.
// and after complete traversal of string exp, if there's any opening parentheses left
// in stack then also return false.
// At the end return true if you haven't encountered any of the above false conditions.
public class BalancedParenthesis {
    public static boolean isBalanced(String exp) {
        Stack<Character> stack = new Stack<>(exp.length());

        for (int i = 0; i < exp.length(); i++) {
            char character = exp.charAt(i);
            if (character == '}' || character == ')' || character == ']') {
                // Closing parenthesis came, Stack is empty, return false as there should have been opening parenthesis for this
                if (stack.isEmpty()) {
                    return false;
                }
                // If Stack is not empty, check on these below conditions, the opening should match the closing
                if ((character == '}' && stack.pop() != '{') || (character == ')' && stack.pop() != '(') || (character == ']' && stack.pop() != '[')) {
                    return false;
                }
            } else { // All openings should be pushed to stack
                stack.push(character);
            }

        } //end of for
        // Stack is not empty after entire process, means it's not balanced, return false
        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String args[]) {

        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("[{(}]"));

    }
}
