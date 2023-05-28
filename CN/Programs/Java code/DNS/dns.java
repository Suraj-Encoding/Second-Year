
// # Assignment-9 -> DNS Implementation
// # Name: Suraj Dalvi - A44
// # Write a program for DNS lookup. Given an IP address input, it should return URL and vice-versa.
import java.net.*;
import java.util.Scanner;

public class dns {
    public static void main(String[] args) {
        System.out.println("\n----- DNS Implementation ------");
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter URL: ");
        String host = sc.nextLine();
        InetAddress addr;
        while (true) {
            System.out.println("\nMenu: ");
            System.out.println("1.URL To IP");
            System.out.println("2.IP To URL");
            System.out.println("3.Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    try {
                        addr = InetAddress.getByName(host);
                        System.out.println("\nIP Address:  " + addr.getHostAddress());
                    } catch (UnknownHostException e) {
                        System.out.println("\nCould not found - " + host + "\n");
                    }
                    break;
                case 2:
                    try {
                        addr = InetAddress.getByName(host);
                        System.out.println("\nHost Address: " + addr.getHostName());

                    } catch (Exception ex) {
                        System.out.println("\nCould not found - " + host + "\n");
                    }
                    break;
                case 3:
                    System.out.println("\nExit..\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nWrong Choice.Please Retry!");
                    break;
            }
        }
    }
}