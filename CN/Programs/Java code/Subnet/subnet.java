
// # Assignment-5 -> Subneting
// # Name: Suraj Dalvi - A44
// # Write a program to demonstrate subneting and find first and last address.
import java.io.*;

public class subnet {

    public static void main(String[] args) throws IOException {
        System.out.println("\n---- Subneting ----");
        System.out.print("\n# Enter IP Address: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip = br.readLine();
        String checkclass = ip.substring(0, 3);

        int cc = Integer.parseInt(checkclass);
        String mask = null;
        if (cc > 0) {
            if (cc <= 127) {
                mask = "255.0.0.0";
                System.out.println("\n# Class-A IP Address");
                System.out.println("\n# Subnet Mask: " + mask);
            }
            if (cc >= 128 && cc <= 191) {
                mask = "255.255.0.0";
                System.out.println("\n# Class-B IP Address");
                System.out.println("\n# Subnet Mask: " + mask);
            }
            if (cc >= 192 && cc <= 223) {
                mask = "255.255.255.0";
                System.out.println("\n# Class C IP Address");
                System.out.println("\n# Subnet Mask: " + mask);
            }
            if (cc >= 224 && cc <= 239) {
                mask = null;
                System.out.println("\n# Class-D IP Address Used for multicasting");
            }
            if (cc >= 240 && cc <= 254) {
                mask = null;
                System.out.println("\n# Class-E IP Address Experimental Use");
            }
            System.out.println();
        }

        if (mask != null) {
            String firstAdd = "";
            String lastAdd = "";
            String[] IpAddParts = ip.split("\\.");
            String[] maskParts = mask.split("\\.");

            for (int i = 0; i < 4; i++) {
                int x = Integer.parseInt(IpAddParts[i]);
                int y = Integer.parseInt(maskParts[i]);
                int z = x & y;
                if (i == 3) {
                    firstAdd += z;
                    int w = z | (y ^ 255);
                    lastAdd += w;
                } else {
                    firstAdd += z + ".";
                    int w = z | (y ^ 255);
                    lastAdd += w + ".";
                }
            }

            System.out.println("# First IP Address: " + firstAdd);
            System.out.println("\n# Last IP Address: " + lastAdd);
            System.out.println();
        } else {
            System.out.println("\n# Invalid IP Address! \n");
        }
    }

}
