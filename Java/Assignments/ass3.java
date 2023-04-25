package Assignments;
// # Suraj Dalvi - A44
// # Assignment-4 : Abstract Class
// # Write a java program to create abstract class named as shape that contains 3 
//   integers and an empty method named as Area().

import java.util.*;

// # Abstract class -> Shape
abstract class Shape {
    int length, breadth, radius;
    Scanner input = new Scanner(System.in);

    abstract void printArea();
}

// # Rectangle
class Rectangle extends Shape {
    void printArea() {
        System.out.println("\n# Area of Rectangle: ");
        System.out.print("Enter length: ");
        length = input.nextInt();
        System.out.print("Enter breadth: ");
        breadth = input.nextInt();
        System.out.println("The area of Rectangle is: " + length * breadth);
    }
}

// # Triangle
class Triangle extends Shape {
    void printArea() {
        System.out.println("\n# Area of Triangle: ");
        System.out.print("Enter Base: ");
        length = input.nextInt();
        System.out.print("Enter Height: ");
        breadth = input.nextInt();
        System.out.println("The area of Triangle is: " + (length * breadth) / 2);
    }
}

// # Circle
class Cricle extends Shape {
    void printArea() {
        System.out.println("\n# Area of Cricle: ");
        System.out.print("Enter Radius: ");
        radius = input.nextInt();
        System.out.println("The area of Cricle is: " + 3.14f * radius * radius);
    }
}

// # Main Class
public class ass3 {

    // # Main Function
    public static void main(String[] args) {
        System.out.println("\n# Assignment-3 : Abstract Class #");
        Rectangle rec = new Rectangle();
        rec.printArea();
        Triangle tri = new Triangle();
        tri.printArea();
        Cricle cri = new Cricle();
        cri.printArea();
        System.out.println();
    }
}
