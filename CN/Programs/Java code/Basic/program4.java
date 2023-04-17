// # Assignment-4 -> CRC
// # Name: Suraj Dalvi - A44
// # Write a program for error detection and correction for 7/8 bits ASCII codes using CRC

import java.util.Scanner;
public class program4 {

    public static void main(String args[]) {

        // # Scanner class for Input
        Scanner input = new Scanner(System.in);
        try {

            // # Variables
            String msg, key, temp;
            int data[], divisor[], quotient[];
            boolean valid;
            int i, j;

            // # Inputd data-stream from sender
            System.out.println("\n# CRC - Error Detection #\n");
            System.out.println("# Sender Side:\n");
            System.out.print(" Enter Data: ");
            msg = input.nextLine();
            temp = msg;
            System.out.print(" Enter key: ");
            key = input.nextLine();

            // # Arrays
            data = new int[msg.length() + key.length() - 1];
            divisor = new int[key.length()];
            quotient = new int[msg.length()];

            // # Converion of char string to integer array
            for (i = 0; i < msg.length(); i++)
                data[i] = Integer.parseInt(msg.charAt(i) + "");
            for (i = 0; i < key.length(); i++)
                divisor[i] = Integer.parseInt(key.charAt(i) + "");

            // # Calculation of CRC
            for (i = 0; i < msg.length(); i++) {
                if (data[i] == 1) {
                    quotient[i] = 1;
                    for (j = 0; j < divisor.length; j++)
                        data[i + j] ^= divisor[j];
                } else
                    quotient[i] = 0;
            }

            // # Display Codeword
            System.out.print("\n Codeword: ");
            for (i = 0; i < msg.length(); i++)
                data[i] = Integer.parseInt(msg.charAt(i) + "");
            for (i = 0; i < data.length; i++)
                System.out.print(data[i]);
            System.out.println();

            // # Display Quotient
            System.out.print(" Quotient: ");
            for (i = 0; i < msg.length(); i++)
                System.out.print(quotient[i]);
            System.out.println();

            // # Display CRC
            System.out.print(" CRC: ");
            for (i = msg.length(); i < data.length; i++)
                System.out.print(data[i]);
            System.out.println();

            // # Receiver Side
            System.out.println("\n# Receiver Side:");
            System.out.print("\n Enter Codeword: ");
            msg = input.nextLine();
            data = new int[msg.length() + key.length() - 1];
            quotient = new int[msg.length()];
            for (i = 0; i < msg.length(); i++)
                data[i] = Integer.parseInt(msg.charAt(i) + "");

            // # Calculation of CRC
            for (i = 0; i < msg.length(); i++) {
                if (data[i] == 1) {
                    quotient[i] = 1;
                    for (j = 0; j < divisor.length; j++)
                        data[i + j] ^= divisor[j];
                } else
                    quotient[i] = 0;
            }

            // # Display Quotient
            System.out.print("\n Quotient: ");
            for (i = 0; i < quotient.length; i++)
                System.out.print(quotient[i]);
            System.out.println();

            // # Display CRC
            System.out.print(" CRC: ");
            for (i = msg.length(); i < data.length; i++)
                System.out.print(data[i]);
            System.out.println();

            // # Display validity of data
            valid = true;
            for (i = 0; i < data.length; i++)
                if (data[i] == 1) {
                    valid = false;
                    break;
                }
            if (valid == true) {
                System.out.println(" Data stream is valid.");
                System.out.println(" Final Data: " + temp + "\n");
            } else
                System.out.println(" Data stream is Invalid. CRC error occurred.\n");
        } finally {
            input.close();
        }
    }
}

// # Logic For Conversion:
// divisor[i] = Integer.parseInt(key.charAt(i) + "");
// OR
// if (key.charAt(i) == '1')
// divisor[i] = 1;
// else
// divisor[i] = 0;