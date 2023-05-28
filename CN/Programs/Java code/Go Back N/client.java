
// # Client Side - Receiving frames from server
import java.io.*;
import java.net.*;
import java.util.*;

class client {
    public static void main(String args[]) throws IOException {
        InetAddress IP = InetAddress.getByName("Localhost");
        Socket connection = new Socket(IP, 1500);
        DataInputStream in = new DataInputStream(connection.getInputStream());
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        Scanner input = new Scanner(System.in);
        System.out.println("\n.......Client Side........\n");
        System.out.println("Connected..!");

        System.out.print("\nEnter the number of frames to be requested to the server: ");
        int c = input.nextInt();
        out.write(c);
        out.flush();

        System.out.print("\nEnter the type of transmission (Error = 1 | NoError = 0) : ");
        int choice = input.nextInt();
        out.write(choice);
        out.flush();

        int check = 0;
        int i = 0;
        int j = 0;

        if (choice == 0) {
            for (j = 0; j < c; j++) {
                i = in.read();
                System.out.println("\nReceived frame no: " + i);
                System.out.println("Sending acknowledgement for frame no: " + i);
                out.write(i);
                out.flush();
            }
            out.flush();
        } 
        else {
            for (j = 0; j < c; j++) {
                i = in.read();
                if (i == check) {
                    System.out.println("\nReceived frame no: " + i);
                    System.out.println("Sending acknowledgement for frame no: " + i);
                    out.write(i);
                    check++;
                } else {
                    --j;
                    System.out.println("\nDiscarded frame no: " + i);
                    System.out.println("Sending Negative Ack");
                    out.write(-1);
                }
                out.flush();
            }
        }
        in.close();
        out.close();
        System.out.println("\nClient Quiting...\n");
    }
}