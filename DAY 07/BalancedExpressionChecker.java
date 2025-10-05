public class BalancedExpressionChecker {

    // Stack implementation for characters
    static class Stack {
        private char[] stackArray;
        private int top;
        private int size;

        public Stack(int size) {
            this.size = size;
            stackArray = new char[size];
            top = -1;
        }

        public void push(char c) {
            if (top >= size - 1) {
                System.out.println("Stack Overflow");
            } else {
                stackArray[++top] = c;
            }
        }

        public char pop() {
            if (top < 0) {
                return '\0'; // empty stack
            }
            return stackArray[top--];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public char peek() {
            if (isEmpty()) return '\0';
            return stackArray[top];
        }
    }

    // Function to check if brackets are balanced
    public static boolean isBalanced(String expr) {
        Stack stack = new Stack(expr.length());

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // Handle closing brackets
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false; // No matching opening
                }

                char top = stack.pop();

                if (!isMatchingPair(top, ch)) {
                    return false; // Mismatched pair
                }
            }
        }

        return stack.isEmpty(); // Should be empty if balanced
    }

    // Helper to check if two brackets match
    public static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String[] expressions = {
            "{[()]}",
            "{[(])}",
            "((a+b)*[c/d])",
            "((a+b]*[c/d])",
            "((a+b)"
        };

        for (String expr : expressions) {
            System.out.println("Expression: " + expr +
                " --> Balanced? " + isBalanced(expr));
        }
    }
}
