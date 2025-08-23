public class ArrayOps {
    public static void main(String[] args) {
        int[] numbers = {12, 45, 7, 89, 23, 56, 78, 34, 90, 11};
        int max = numbers[0], min = numbers[0], sum = 0;

        for (int num : numbers) {
            if (num > max) max = num;
            if (num < min) min = num;
            sum += num;
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Sum: " + sum);
    }
}
