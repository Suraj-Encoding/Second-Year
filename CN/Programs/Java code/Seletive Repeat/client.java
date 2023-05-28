
// # Client Side - Receiving frames from server
import java.io.*;
import java.net.*;

public class client {
    static Socket connection;

    public static void main(String args[]) throws SocketException {
        try {
            int v[] = new int[8];
            int n = 0;
            System.out.println("\n........Client Side........\n");
            InetAddress IP = InetAddress.getByName("Localhost");
            int port = 8011;
            connection = new Socket(IP, port);
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            DataInputStream in = new DataInputStream(connection.getInputStream());
            int p = in.read();
            System.out.println("Number of frames receives is: " + p);
            System.out.println("\nReceived Frames are: \n");
            for (int i = 0; i < p; i++) {
                v[i] = in.read();
                v[5] = -1;
                System.out.print("Frame-" + i + " : " + v[i]);
                System.out.println();
            }
            for (int i = 0; i < p; i++) {
                if (v[i] == -1) {
                    System.out.println("\nRequest server to retransmit the frame-" + i + " again..!");
                    n = i;
                    out.write(n);
                    out.flush();
                }
            }
            System.out.println();
            v[n] = in.read();
            System.out.println("Received frame is: " + v[n]);
            System.out.println("\nClient Quit...\n");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}