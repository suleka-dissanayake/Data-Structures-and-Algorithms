import java.util.Scanner;

class Sum{
    static int getSum(int num){
        if(num <= 1){
            return 1;
        } else{
            return num + (getSum(num - 1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.println("Summation from 0 to " + num + " is " + getSum(num));
        sc.close();
    }
}