class Number_of_Digits {
    static int i = 0;
    static int getNumOfDigits(int num){
        if(num <= 0){
            return i;
        } else{
            num = num / 10;
            i++;
            getNumOfDigits(num);
            return i;
        }
    }

    public static void main(String[] args) {
        System.out.println("Character count is " + getNumOfDigits(5578));
    }
}