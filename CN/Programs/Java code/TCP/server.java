// # Readng File Data Using TCP Socket Programming

// # TCP Server Side 
import java.net.*;
import java.io.*;

public class server {
    public static void main(String[] args) throws Exception {

        // # Server Socket
        ServerSocket sersock = new ServerSocket(4000);
        System.out.println("\n# Server Side: ");
        System.out.println("\nServer ready for connection...");

        // # Client Socket and Server Socket connection
        Socket sock = sersock.accept();
        System.out.println("Connection is successful and waiting for chatting");

        // # Input Stream Classes
        InputStream istream = sock.getInputStream();
        BufferedReader fileRead = new BufferedReader(new InputStreamReader(istream));

        // # Read data from socket
        String fname = fileRead.readLine();
        BufferedReader ContentRead = new BufferedReader(new FileReader(fname));
        OutputStream ostream = sock.getOutputStream();

        // # For printing like System.out
        PrintWriter pwrite = new PrintWriter(ostream, true);

        // # Write data on socket - pass to client
        String str;
        while ((str = ContentRead.readLine()) != null) {
            pwrite.println(str);
        }
        System.out.println("\nConnection terminated...");

        // # Close all objects
        sock.close();
        sersock.close();
        pwrite.close();
        fileRead.close();
        ContentRead.close();
    }
}
