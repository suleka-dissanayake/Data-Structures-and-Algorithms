import java.util.Scanner;

class Factorial{
    static int getfactorial(int num){
        int fact = 1;
        if(num <=1){
            return fact;
        } else{
            return num * (getfactorial(num - 1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.println("Factorial is " + getfactorial(num));
        sc.close();
    }
}