//question 10
//Print diagonal sum in an array
public class DiagonalSum {
    public static void diagonalSum(int matrix[][]) {
        int sum = 0;

        // normal method
        // Time complexity-> O(n2)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) { // To calculate sum of primary diagonal elements
                    sum += matrix[i][j];
                } else if ((i + j) == matrix.length - 1) { // To calculate sum of secondary diagonal elements

                    sum += matrix[i][j];
                }
            }
        }

        // effective method
        // Time complexity-> O(n)
        // for (int i = 0; i < matrix.length; i++) {
        // // primary diagonal sum
        // sum += matrix[i][i];
        // // secondary diagonal sum
        // if (i != matrix.length - 1 - i)
        // sum += matrix[i][matrix.length - i - 1];
        // }

        System.out.println("Diagonal sum is: " + sum);
    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        diagonalSum(matrix);

    }
}
