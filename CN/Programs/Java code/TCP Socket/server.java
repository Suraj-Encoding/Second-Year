// # Assignment-4 -> TCP Socket Programming
// # Name: Suraj Dalvi - A44
// # Implement Peer to Peer Chat using TCP Socket Programming

// # TCP Server Side
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class server {
    public static void main(String args[]) throws Exception {

        // # Server Socket - Pass port only
        ServerSocket ss = new ServerSocket(3333);

        // # client socket connect with server socket
        Socket s = ss.accept();

        // # I/O Streams
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        // # Two classes for taking input
        Scanner input = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // # Actual chat logic in while loop unitl 'Bye' will not hit
        // # Chatting is done parallel

        // String str = "", str2 = "";
        // System.out.println("\n----------------------------------------------------------");
        // System.out.println("\t\tServer Side ");
        // System.out.println("----------------------------------------------------------");
        // while (!str.equals("Bye")) {
        // str = din.readUTF(); // read msg from socket - come from client
        // System.out.println(" Client: " + str); // print client reply
        // System.out.print(" You: ");
        // str2 = br.readLine(); // read input from keyboard
        // dout.writeUTF(str2); // write msg on socket - pass it to server
        // dout.flush(); // clear msg from dout object
        // System.err.println();
        // }
        // System.out.println("Connection terminated...");
        // System.out.println("----------------------------------------------------------");

        // # Passing array to client
        int size;
        System.out.print("\nEnter array size: ");
        size = br.read();
        dout.write(size);
        int a[];
        a = new int[size];
        System.out.print("Enter array: ");
        for (int i = 0; i < size; i++) {
            a[i] = input.nextInt();
            dout.write(a[i]);
            dout.flush();
        }
        System.out.println("Array send to client...");

        // # At the end close all the objects of classes
        din.close();
        s.close();
        ss.close();
    }
}