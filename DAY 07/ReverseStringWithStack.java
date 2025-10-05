public class ReverseStringWithStack {

    // Manual Stack implementation
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
                System.out.println("Stack Underflow");
                return '\0';
            } else {
                return stackArray[top--];
            }
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    // Reverse string using stack and character array (no StringBuilder)
    public static String reverseString(String str) {
        int n = str.length();
        Stack stack = new Stack(n);

        // Push all characters onto the stack
        for (int i = 0; i < n; i++) {
            stack.push(str.charAt(i));
        }

        // Create a character array to store reversed characters
        char[] reversedChars = new char[n];
        int index = 0;

        // Pop characters from the stack into the array
        while (!stack.isEmpty()) {
            reversedChars[index++] = stack.pop();
        }

        // Return the new string from the character array
        return new String(reversedChars);
    }

    public static void main(String[] args) {
        String original = "hello world";
        String reversed = reverseString(original);

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}
