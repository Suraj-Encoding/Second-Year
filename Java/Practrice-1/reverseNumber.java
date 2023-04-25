//practice 2
//reverse number

import java.util.*;
public class reverseNumber {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number: ");
        int n=sc.nextInt();
        int LastDigit;
        int reverseNum;
        while(n!=0){
            LastDigit=n/10;
            reverseNum=LastDigit%2;
    
        System.out.println(reverseNum);

    }
    
}
}