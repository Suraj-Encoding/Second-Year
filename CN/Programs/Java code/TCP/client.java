
// # TCP Client Side
import java.net.*;
import java.io.*;

public class client {
    public static void main(String[] args) throws Exception {

        // # Client Socket
        Socket sock = new Socket("127.0.01", 4000);
        
        // # Read Filename
        System.out.println("\nClient Side: ");
        System.out.print("\nEnter the filename: ");
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        String fname = keyRead.readLine();

        // # Write data on socket
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);
        pwrite.println(fname);
        
        // # Input Stream Classes
        InputStream istream = sock.getInputStream();
        BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
        
        // # Print file content - come from server
        System.out.print("File Data: ");
        String str;
        while ((str = socketRead.readLine()) != null) {
            System.out.println(str);
        }
        System.out.println("\nConnection terminated...");

        // # Close
        pwrite.close();
        socketRead.close();
        keyRead.close();
    }
}