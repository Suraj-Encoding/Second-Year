
// # UDP Client Side
import java.io.*;
import java.net.*;
import java.net.InetAddress;

class client {
    public static void main(String[] args) throws Exception {

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress IPAddress = InetAddress.getByName("localhost");

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        System.out.println("\nClient is ready...");
        while (true) {
            // # Read string input
            System.out.print("\nEnter the string to be converted in to Upper case: ");
            String sentence = inFromUser.readLine();

            sendData = sentence.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);

            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            clientSocket.receive(receivePacket);

            String modifiedSentence = new String(receivePacket.getData());

            System.out.println("From Server:" + modifiedSentence);
            if (modifiedSentence == "STOP") {
                System.out.println("\nConnection terminated...");
                break;
            }
        }
        clientSocket.close();
    }
}
