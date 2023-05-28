// # URL to IP
import java.net.*;
import java.util.Scanner;

public class dns1 {
  private static String url = null;
public static void main (String[] args) {
    try {
      System.out.println("\n# DNS Implementation #");
      System.out.println("\n---- URL to IP -----");
      Scanner input = new Scanner(System.in);
      System.out.print("\nEnter Domain URL: ");
      String URL = input.nextLine();
      url = URL;
      InetAddress IP = InetAddress.getByName(URL);
      String ip = IP.getHostAddress();
      System.out.print("\nIP Address: " + ip + "\n\n");
    } catch (UnknownHostException e) {
      System.out.println("\nCould not found - " + url + "\n");
    }
  }
}
