//que-2
//compare strings
import java.util.*;

public class StringCmp {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1: ");
        String s1 = sc.nextLine();
        System.out.println("Enter string 2: ");
        String s2 = sc.nextLine();
        if (s1.equals(s2)) {
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are not equal");
        }

    }

}
