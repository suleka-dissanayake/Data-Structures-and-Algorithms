import java.util.*;

public class Stack_DecToBin {
    private int maxSize, top = -1;
    private String[] stackArray;

    public Stack_DecToBin(int size) {
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

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void convertDecimaltoBinary(int data) {
        while (data > 0) {
            int remainder = data % 2;
            this.push(String.valueOf(remainder));
            data /= 2;
        }

        System.out.print("Binary number is: ");
        while (!this.isEmpty()) {
            System.out.print(this.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int input = scanner.nextInt();

        Stack_DecToBin stack = new Stack_DecToBin(32);
        stack.convertDecimaltoBinary(input);

        scanner.close();
    }
}