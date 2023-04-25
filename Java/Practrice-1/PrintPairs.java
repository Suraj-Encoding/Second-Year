//question 6
    // PRINT  all PAIRS 
    public class PrintPairs {
    public static void Printpairs(int num[]) {
        int totalPairs = 0;
        for (int i = 0; i < num.length; i++) {
            int current = num[i];
            for (int j = i + 1; j < num.length; j++) {
                System.out.print("(" + current + "," + num[j] + ")");
                totalPairs++;
            }
            System.out.println();
            
        }
        System.out.println("total pairs is: " + totalPairs);
    }

    public static void main(String args[]) {
        int num[] = { 2, 4, 6, 8, 10 };
        Printpairs(num);
    }
}
