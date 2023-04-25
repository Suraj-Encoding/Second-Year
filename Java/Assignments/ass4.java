package Assignments;
// # Suraj Dalvi - A44
// # Assignment-4 : Linked List
// # Implement a linked list in Java for storing the employee information (such as Employee Number, Name, Department, etc.). 
//   Print the linked list and delete the node from the linked list from a given position.

// # Employee Class
class Employee {
    int employeeNumber;
    String name;
    String department;

    public Employee(int employeeNumber, String name, String department) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

// # Node
class Node {
    Employee employee;
    Node next;

    public Node(Employee employee) {
        this.employee = employee;
        this.next = null;
    }
}

// # Linked List
class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // # Add Node
    public void add(Employee employee) {
        Node newnode = new Node(employee);
        if (head == null) {
            head = newnode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newnode;
        }
    }

    // # Print List
    public void printList() {
        Node current = head;
        while (current != null) {
            // System.out.println(current.employee.toString());
            if (current == head)
                System.err.println("Employee No   Employee Name   Depatment");
            System.out.println(current.employee.employeeNumber + "\t\t " + current.employee.name + " \t\t"
                    + current.employee.department);
            current = current.next;
        }
    }

    // # Delete Node
    public void deleteNode(int position) {
        if (head == null) {
            return;
        }
        Node temp = head;
        if (position == 0) {
            head = temp.next;
            return;
        }
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            return;
        }
        Node next = temp.next.next;
        temp.next = next;
    }
}

// # Main class
public class ass4 {

    // # Main Function
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new Employee(1, "Suraj", "Computer"));
        list.add(new Employee(2, "Ronak", "IT"));
        list.add(new Employee(3, "Rohan", "Dancer"));
        list.add(new Employee(4, "Raman", "Business"));
        list.add(new Employee(5, "Haris", "Doctor"));
        System.out.println("\n# Assignment-4 : Linked List #");
        System.out.println("\n# Original List: ");
        list.printList();
        System.out.println("\n# List after deleting node at position 3:");
        list.deleteNode(3);
        list.printList();
        System.err.println();
    }
}
