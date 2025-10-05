public class PalindromeWithStack {

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
                return '\0'; // null character
            } else {
                return stackArray[top--];
            }
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    // Palindrome check using stack
    public static boolean isPalindrome(String str) {
        int n = str.length();
        Stack stack = new Stack(n);

        // Push all characters
        for (int i = 0; i < n; i++) {
            stack.push(str.charAt(i));
        }

        // Pop and compare
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // Main method
    public static void main(String[] args) {
        String[] testStrings = { "madam", "racecar", "hello", "level", "world" };

        for (String s : testStrings) {
            System.out.println(s + " is palindrome? " + isPalindrome(s));
        }
    }
}
