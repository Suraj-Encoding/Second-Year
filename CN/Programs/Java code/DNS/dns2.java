
// # IP to URL
import java.net.*;
import java.util.Scanner;

public class dns2 {
    private static String ip = null;

    public static void main(String[] args) {
        try {
            System.out.println("\n# DNS Implementation #");
            System.out.println("\n---- IP to URL -----");
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter IP Address: ");
            String IP = input.nextLine();
            ip = IP;
            InetAddress URL = InetAddress.getByName(IP);
            String url = URL.getHostName();
            System.out.print("\nDomain URL: " + url + "\n\n");
        } catch (UnknownHostException e) {
            System.out.println("\nCould not found - " + ip + "\n");
        }
    }
}
