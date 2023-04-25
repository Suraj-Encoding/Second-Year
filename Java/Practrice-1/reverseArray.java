//practice 1
//reverse array

import java.util.*;

public class reverseArray {
    public static void ReverseArray(int arr[], int n) {
        int si = 0;
        int ei = n - 1;

        while (si < ei) {

            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;

            si++;
            ei--;
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Print array
        System.out.println("Reverse array is: ");
        ReverseArray(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

}
