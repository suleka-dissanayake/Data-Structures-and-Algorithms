import java.util.*;

public class Stack_Palindrome {
    private int maxSize, top = -1;
    private String[] stackArray;

    public Stack_Palindrome(int size) {
        this.maxSize = size;
        stackArray = new String[maxSize];
    }

    public void push(String x) {
        if (isFull()) {
            System.out.println("Stack Overflow!");
        } else {
            stackArray[++top] = x;
        }
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return null;
        } else {
            String temp = stackArray[top];
            stackArray[top--] = null;
            return temp;
        }
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stackArray[top];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void displayAllElements() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + ", ");
            }
        }
        System.out.println();
    }

    public boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        Stack_Palindrome stack = new Stack_Palindrome(input.length());
        for (int i = 0; i < input.length(); i++) {
            stack.push(String.valueOf(input.charAt(i)));
        }
        for (int i = 0; i < input.length(); i++) {
            String popped = stack.pop();
            if (!popped.equalsIgnoreCase(String.valueOf(input.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public void printPalindromeResult(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("Invalid input!");
            return;
        }
        boolean result = isPalindrome(input);
        if (result) {
            System.out.println(input + " is a palindrome");
        } else {
            System.out.println(input + " is not a palindrome");
        }
    }

    public static void main(String[] args) {
        Stack_Palindrome s1 = new Stack_Palindrome(5);
        s1.push("Apple");
        s1.push("Orange");
        s1.push("Car");
        s1.push("Cat");
        s1.push("Dog");

        s1.pop();
        s1.pop();
        s1.displayAllElements();

        s1.printPalindromeResult("madam");
        s1.printPalindromeResult("radar");
        s1.printPalindromeResult("hello");
    }
}
