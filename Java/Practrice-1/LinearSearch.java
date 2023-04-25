//Practice 4
//Linear search
//Time complexity=O(n)

import java.util.*;

public class LinearSearch {
    // linear search fun
    public static int LinearSearch(int num[], int key) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int num[] = { 1, 3, 45, 6, 7, 4, 8, 9, 10 };
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter key:");
        int key = sc.nextInt();
        int index = LinearSearch(num, key);
        if (index == -1) {
            System.out.println("Key is not found");
        } else {
            System.out.println("key is found");
        }

    }

}
