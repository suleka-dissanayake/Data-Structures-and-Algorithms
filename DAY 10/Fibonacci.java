import java.util.Scanner;

class Fibonacci {
    static int getFibonacci(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        return getFibonacci(num - 1) + getFibonacci(num - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.println("Fibonacci number is " + getFibonacci(num));
        sc.close();
    }
}


