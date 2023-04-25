
//practice 5
//BINARY SEARCH
import java.util.*;

public class BinarySearch {
    public static int BinarySearch(int num[], int key) {
        int start = 0;
        int end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (num[mid] == key) {
                return mid;
            } else if (mid > key) {
                end = mid - 1; // left part

            } else {
                start = mid + 1; // right part

            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int num[] = { 0,1, 2, 3, 4, 5, 6, 7, 8, 90, 98 };
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter key: ");
        int key = sc.nextInt();

        // System.out.println("key is at index: " + BinarySearch(num, key));
        int index = BinarySearch(num, key);
        if (index == -1) {
            System.out.println("Key is not found");
        } else {
            System.out.println("Key is found at index: " + index);
        }
    }
}
