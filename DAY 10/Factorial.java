import java.util.Scanner;

class Factorial{
    static int getfactorial(int num){
        if(num <= 1){
            return 1;
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

