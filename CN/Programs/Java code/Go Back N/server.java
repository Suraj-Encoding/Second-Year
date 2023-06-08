// # Assignment-4 -> Go Back N  (Part-1)
// # Name: Suraj Dalvi - A44
// # Write a program to simulate Go back N and Selective Repeat Modes of Sliding Window Protocol.

// # Server Side - Sending frames to client 
import java.io.*;
import java.net.*;

public class server {
    public static void main(String args[]) throws IOException {
        System.out.println("\n.......Server Side.......\n");
        System.out.println("Waiting for connection....");

        ServerSocket ss = new ServerSocket(1500);
        Socket client = new Socket();
        client = ss.accept();

        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

        int p = in.read();
        System.out.println("\nReceived request for sending frames!");

        boolean f[] = new boolean[p];

        int pc = in.read();

        System.out.println("\nSending Frames....\n");

        if (pc == 0) {
            for (int i = 0; i < p; i++) {
                System.out.println("\nSending frame number " + i);
                out.write(i);
                out.flush();
                System.out.println("Waiting for acknowledgement");
                try {
                    Thread.sleep(7000);
                } catch (Exception e) {
                }
                int a = in.read();
                System.out.println("Received acknowledgement for frame " + i + " as " + a);
            }
            out.flush();
        } else {
            for (int i = 0; i < p; i++) {
                if (i == 2) {
                    System.out.println("\nSending frame no " + i);
                } else {
                    System.out.println("\nSending frame no " + i);
                    out.write(i);
                    out.flush();
                    System.out.println("Waiting for acknowledgement ");
                    try {
                        Thread.sleep(7000);
                    } catch (Exception e) {
                    }

                    int a = in.read();

                    if (a >= 0) {
                        System.out.println("Received acknowledgement for frame no: " + i + " as " + a);
                        f[i] = true;
                    }
                }
            }

            for (int a = 0; a < p; a++) {
                if (f[a] == false) {
                    System.out.println("Resending frame " + a);
                    out.write(a);
                    out.flush();
                    System.out.println("Waiting for ack ");
                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {
                    }
                    int b = in.read();
                    System.out.println("Received ack for frame no: " + a + " as " + b);
                    f[a] = true;
                }
            }
            out.flush();
        }
        in.close();
        out.close();
        client.close();
        ss.close();
        System.out.println("\nServer Quiting...\n");
    }
}