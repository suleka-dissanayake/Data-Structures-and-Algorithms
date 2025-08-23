import java.util.Scanner;

public class Array2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("\nEnter matrix values:");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter value for [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }

        System.out.println("\nMatrix:");
        for (int[] row : matrix) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }

        int max = matrix[0][0], min = matrix[0][0];
        for (int[] row : matrix)
            for (int val : row) {
                if (val > max) max = val;
                if (val < min) min = val;
            }

        System.out.println("\nMax: " + max);
        System.out.println("Min: " + min);

        System.out.println("\nRow Sums:");
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < cols; j++) rowSum += matrix[i][j];
            System.out.println("Row " + i + ": " + rowSum);
        }

        System.out.println("\nColumn Sums:");
        for (int j = 0; j < cols; j++) {
            int colSum = 0;
            for (int i = 0; i < rows; i++) colSum += matrix[i][j];
            System.out.println("Col " + j + ": " + colSum);
        }

        sc.close();
    }
}
