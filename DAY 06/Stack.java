import java.util.*;

public class Stack {
    int maxSize, top = -1;
    String stackArray[];

    public Stack(int size) {
        this.maxSize = size;

        stackArray = new String[maxSize];
    }

    public void push(String x) {
        if (isFull()) {
            System.out.println("Stack Overflow!");
        } else {
            top++;
            stackArray[top] = x;
        }
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return null;
        } else {
            String temp = stackArray[top];
            stackArray[top] = null;
            top--;
            return temp;
        }
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Empty!");
            return null;
        } else {
            return stackArray[top];
        }
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
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + ", ");
        }
        System.out.println();
    }

    public boolean isPalindrome() {
        for (int i = 0; i <= top; i++) {
            String str = stackArray[i];
            String reversed = new StringBuilder(str).reverse().toString();
            if (!str.equals(reversed)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack s1 = new Stack(5);
        System.out.print("Enter something: ");
        String inp1 = sc.next();
        s1.push(inp1);

        s1.displayAllElements();
        System.out.println(s1.isPalindrome());
    }
}