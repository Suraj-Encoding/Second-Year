// # Suraj Dalvi - A44
// # Assignment-1 
// # Write a java program to find the largest element from the array

import java.util.*;

public class ass1 {

    // # LargeSmall Method
    public static void LargeSmall(int arr[], int n) {
        int max = Integer.MIN_VALUE; // -Infinty
        int min = Integer.MAX_VALUE; // +Infinty
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }

        }
        // # Display min and max element
        System.out.println("\n# Output: ");
        System.out.println("  Largest element: " + max);
        System.out.println("  Smallest element: " + min);
        System.out.println();

    }

    // # Main Function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n# Assignment-1 #");
        System.out.print("\nEnter array size: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        // # Read array
        System.out.print("\nEnter array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // # display array
        System.out.print("\nEntered array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        LargeSmall(arr, n);

    }

}