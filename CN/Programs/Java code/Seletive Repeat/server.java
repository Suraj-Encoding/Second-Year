// # Assignment-4 -> Selective Repeat (Part-2)
// # Name: Suraj Dalvi - A44
// # Write a program to simulate Go back N and Selective Repeat Modes of Sliding Window Protocol.

// # Server Side - Sending frames to client
import java.io.*;
import java.net.*;

public class server {
    static ServerSocket Serversocket;
    static DataInputStream dis;
    static DataOutputStream dos;

    public static void main(String args[]) throws SocketException {
        try {
            int a[] = { 30, 40, 50, 60, 70, 80, 90, 100 };
            Serversocket = new ServerSocket(8011);
            System.out.println("\n........Server Side........\n");
            System.out.println("Waiting for connection...");
            Socket client = Serversocket.accept();
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());
            System.out.println("\nThe number of frames sent is: " + a.length);
            int y = a.length;
            dos.write(y);
            dos.flush();
            System.out.println("\nSending Frames...\n");
            for (int i = 0; i < a.length; i++) {
                dos.write(a[i]);
                dos.flush();
            }
            int k = dis.read();
            System.out.println("Retransmitting frame-" + k);
            dos.write(a[k]);
            dos.flush();
            System.out.println("\nSending frame: " + a[k]);
            System.out.println("\nServer Quit...\n");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}