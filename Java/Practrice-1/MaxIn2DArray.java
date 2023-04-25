//question 9
//create 2D array and max and min element from array
import java.util.*;

public class MaxIn2DArray {
    // print smallest element in array
    public static void SmallALarge(int matrix[][]) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (smallest > matrix[i][j]) {
                    smallest = matrix[i][j];
                }
                if (largest < matrix[i][j]) {
                    largest = matrix[i][j];
                }
            }
        }
        System.out.println("Smallest element in 2D array is: " + smallest);
        System.out.println("largest element in 2D array is: " + largest);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of rows: ");
        int m = sc.nextInt();
        System.out.println("Enter no of columns: ");
        int n = sc.nextInt();
        int matrix[][] = new int[m][n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        SmallALarge(matrix);

    }
}
