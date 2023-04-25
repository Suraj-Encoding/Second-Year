
//question 8
//Create 2D array
import java.util.*;

public class Array2D {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of rows:");
        int m = sc.nextInt();
        System.out.println("Enter no of columns: ");
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println();
        System.out.println("#Given array: ");
        // Print array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}
