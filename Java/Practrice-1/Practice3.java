//Practice 3
//Input output 

import java.util.*;
public class Practice3 {
        public static void main(String args[]){
        int marks[]=new int[100];
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 5 subject marks: ");
        marks[0]=sc.nextInt();  //phy
        marks[1]=sc.nextInt();  //chem
        marks[2]=sc.nextInt();  //maths
        marks[3]=sc.nextInt();  //bio
        marks[4]=sc.nextInt();  //computer science
        System.out.println("phy: "+ marks[0]);
        System.out.println("chem: "+ marks[1]);
        System.out.println("maths: "+ marks[2]);
        System.out.println("bio: "+ marks[3]);
        System.out.println("computer science: "+ marks[4]);
    }

}
    

