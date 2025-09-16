import java.util.*;

public class Stack_DecToHex {
    private int maxSize, top = -1;
    private String[] stackArray;

    public Stack_DecToHex(int size) {
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

    public void convertDecimaltoHexaDecimal(int data) {
        if (data == 0) {
            push("0");
        }
    
        while (data > 0) {
            int remainder = data % 16;
            if (remainder < 10) {
                push(String.valueOf(remainder));
            } else {
                push(String.valueOf((char) ('A' + (remainder - 10))));
            }
            data /= 16;
        }
    
        System.out.print("Hexadecimal number is: ");
        while (!isEmpty()) {
            System.out.print(pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int input = scanner.nextInt();

        Stack_DecToHex stack = new Stack_DecToHex(32);
        stack.convertDecimaltoHexaDecimal(input);

        scanner.close();
    }
}