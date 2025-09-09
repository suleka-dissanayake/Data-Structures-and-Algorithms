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

    public static void main(String[] args) {
        Stack s1 = new Stack(5);
        s1.push("Apple");
        s1.push("Orange");
        s1.push("Car");
        s1.push("Cat");
        s1.push("Dog");

        s1.pop();
        s1.pop();
        s1.displayAllElements();
    }
}