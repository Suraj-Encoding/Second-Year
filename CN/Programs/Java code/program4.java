// # Assignment-4 -> CRC
// # Write a program for error detection and correction for 7/8 bits ASCII codes using CRC

import java.util.Scanner;

public class program4 {

    public static void main(String args[]) {

        // # Scanner class for Input
        Scanner input = new Scanner(System.in);
        try {

            // # Variables
            String msg, key;
            int data[], divisor[], quotient[];
            boolean valid;
            int i, j;

            // # Input Data Stream
            System.out.println("\n# CRC : Error Detection #\n");
            System.out.print("Enter Data: ");
            msg = input.nextLine();
            System.out.print("Enter key: ");
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

            // # Display codeword
            System.out.print("codeword: ");
            for (i = 0; i < msg.length(); i++)
                data[i] = Integer.parseInt(msg.charAt(i) + "");
            for (i = 0; i < data.length; i++)
                System.out.print(data[i]);
            System.out.println();

            // # Display Quotient
            System.out.print("Quotient: ");
            for (i = 0; i < msg.length(); i++)
                System.out.print(quotient[i]);
            System.out.println();

            // # Display CRC
            System.out.print("CRC: ");
            for (i = msg.length(); i < data.length; i++)
                System.out.print(data[i]);
            System.out.println();

            // # Receiver Side
            System.out.print("Enter codeword: ");
            msg = input.nextLine();
            data = new int[msg.length() + key.length() - 1];
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
            System.out.print("Quotient: ");
            for (i = 0; i < msg.length(); i++)
                System.out.print(quotient[i]);
            System.out.println();

            // # Display CRC
            System.out.print("CRC: ");
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
            if (valid == true)
                System.out.println("Data stream is valid");
            else
                System.out.println("Data stream is Invalid. CRC error occurred.");
        } finally {
            input.close();
        }

    }
}

// # Note:
// msg = dataword -> actual data
// key = divisor = divisor/generator
// CRC = Remainder
// data = codeword
// codeword = checksum code = dataword + CRC -> divident
// quotient = codeword / key

// # Logic:
// divisor[i] = Integer.parseInt(key.charAt(i) + "");
// OR
// if (key.charAt(i) == '1')
// divisor[i] = 1;
// else
// divisor[i] = 0;