
import javax.print.attribute.standard.PrinterInfo;

// public class oopbasic {
//     public static void main(String args[]) {
//         Pen p1 = new Pen(); // object is created called p1
//         p1.setColor("Blue");
//         System.out.println(p1.getcolor());
//         p1.setTip(5);
//         System.out.println(p1.getTip());

//     }
// }

// class Pen {
//     private String color;
//     private int tip;

//     String getcolor() {
//         return this.color;
//     }

//     int getTip() {
//         return this.tip;
//     }

//     void setColor(String newcolor) {
//         this.color = newcolor;

//     }

//     void setTip(int newtip) {
//         this.tip = newtip;
//     }
// }

// class Student {
//     String name;
//     int roll;
//     String password;

//     Student() {
//         System.out.println("Constructor is called....");
//     }

// }

// class Pen {
//     String color;
//     String type;

//     public static void print() {
//         System.out.println("write something");

//     }
//     public void PrintColor(){
//         System.out.println(this.color);
//     }
// }

// public class oopbasic {
//     public static void main(String args[]) {

//         Pen pen1 = new Pen(); // object is created called p1
//         pen1.color = "Blue";
//         pen1.type = "gel";
//         Pen pen2 = new Pen();
//         pen2.color = "black";
//         pen2.type = "Ballpoint";
//         pen1.print();
//         pen2.print();
//         pen1.PrintColor();
//         pen2.PrintColor();

//     }
// }

class Student {
    String name;
    int age;

    Student(String name, int age) { // parametized constructor
        this.name = name;
        this.age = age;

    }

    public void printInfo() {
        System.out.println(this.name);
        System.out.println(this.age);
    }

}

public class oopbasic {
    public static void main(String args[]) {
        Student s1 = new Student("Pratiksha", 19);
        // s1.name="Pratiksha";
        // s1.age=19;
        s1.printInfo();
    }
}
