// # Assignment-4 -> CRC
// # Write a program for error detection and correction for 7/8 bits ASCII codes using CRC.

import java.util.Scanner;

public class program4 {

    public static void main(String args[]) {

        // # Scanner class for Input
        Scanner input = new Scanner(System.in);
        try {
            // # Variables: msg - dataword and key - divisor
            String msg, key;

            // # Input Data Stream
            System.out.println("Enter Data: ");
            msg = input.nextLine();
            System.out.println("Enter key: ");
            key = input.nextLine();
            int data[] = new int[msg.length() + key.length() - 1];
            int divisor[] = new int[key.length()];
            for (int i = 0; i < msg.length(); i++)
                data[i] = Integer.parseInt(msg.charAt(i) + "");
            for (int i = 0; i < key.length(); i++)
                divisor[i] = Integer.parseInt(key.charAt(i) + "");

            // # Calculation of CRC Bits
            for (int i = 0; i < msg.length(); i++) {
                if (data[i] == 1)
                    for (int j = 0; j < divisor.length; j++)
                        data[i + j] ^= divisor[j];
            }

            // # Display CRC
            System.out.println("The checksum code is: ");
            for (int i = 0; i < msg.length(); i++)
                data[i] = Integer.parseInt(msg.charAt(i) + "");
            for (int i = 0; i < data.length; i++)
                System.out.print(data[i]);
            System.out.println();

            // # Check for input CRC code
            System.out.println("Enter checksum code: ");
            msg = input.nextLine();
            System.out.println("Enter key: ");
            key = input.nextLine();
            data = new int[msg.length() + key.length() - 1];
            divisor = new int[key.length()];
            for (int i = 0; i < msg.length(); i++)
                data[i] = Integer.parseInt(msg.charAt(i) + "");
            for (int i = 0; i < key.length(); i++)
                divisor[i] = Integer.parseInt(key.charAt(i) + "");

            // # Calculation of remainder
            for (int i = 0; i < msg.length(); i++) {
                if (data[i] == 1)
                    for (int j = 0; j < divisor.length; j++)
                        data[i + j] ^= divisor[j];
            }

            // # Display validity of data
            boolean valid = true;
            for (int i = 0; i < data.length; i++)
                if (data[i] == 1) {
                    valid = false;
                    break;
                }

            if (valid == true)
                System.out.println("Data stream is valid");
            else
                System.out.println("Data stream is invalid. CRC error occurred.");
        } finally {
            input.close();
        }

    }
}