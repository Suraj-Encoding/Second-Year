
// # TCP Client Side
import java.net.*;
import java.io.*;

public class client {
    public static void main(String args[]) throws Exception {

        // # Client Socket - localhost means this machine IP address
        Socket s = new Socket("localhost", 4400);

        // # I/O streams for socket => Read by din and write by dout
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        // # BufferedReader class for taking input from keyboard like Scanner Class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // # Actual chat logic in while loop unitl 'Bye' will not hit
        String str = "", str2 = "";
        System.out.println("\n----------------------------------------------------------");
        System.out.println("\t\tClient Side ");
        System.out.println("----------------------------------------------------------");
        while (!str.equals("Bye")) {
            System.out.print(" You: ");
            str = br.readLine(); // read input from keyboard
            dout.writeUTF(str); // write msg on socket - pass it to server
            dout.flush(); // clear msg from dout object
            str2 = din.readUTF(); // read msg from socket - come from server
            System.out.println(" Server: " + str2); // print server reply
            System.err.println();
        }
        System.out.println("Connection terminated...");
        System.out.println("----------------------------------------------------------");

        // # At the end close all the objects of classes
        dout.close();
        din.close();
        s.close();
        br.close();
    }
}