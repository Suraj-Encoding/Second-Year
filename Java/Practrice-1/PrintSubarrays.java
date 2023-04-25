//question 7
//PRINT SUBARRAYS
public class PrintSubarrays {

    // function to print all subarrays
    public static void PrintSubarrays(int numbers[]) {
        int totalSubarr = 0;
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print(numbers[k] + " ");

                }
                totalSubarr++;
                System.out.println();

            }
            System.out.println();
        }
        System.out.println("Total subarrays is: " + totalSubarr);
    }

    public static void main(String args[]) {
        int numbers[] = { 2, 4, 6, 8, 10 };
        PrintSubarrays(numbers);
    }
}
