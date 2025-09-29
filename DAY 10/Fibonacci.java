import java.util.Scanner;

class Fibonacci {
    static int getFibonacci(int num){
        int fibonacciNum = 1;
        if(num <= 1){
            return 1;
        } else{
            num -= 1;
            fibonacciNum += num;
            num -= 2;
            fibonacciNum += num;
        }
        return fibonacciNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.println("Recursive number is " + getFibonacci(num));
        sc.close();
    }
}
