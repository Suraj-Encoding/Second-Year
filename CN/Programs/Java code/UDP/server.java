
// # UDP Socket Programming
// # Convert string to upper case

// # UDP Server Side
import java.net.*;
import java.net.InetAddress;

class server {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        System.out.println("\nServer is ready..");
        while (true) {

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            serverSocket.receive(receivePacket);

            String sentence = new String(receivePacket.getData());

            System.out.println("\nReceived Data:" + sentence);
            if (sentence == "stop") {
                System.out.println("\nConnection terminated...");
                break;
            }

            InetAddress IPAddress = receivePacket.getAddress();

            int port = receivePacket.getPort();

            String capitalizedSentence = sentence.toUpperCase();

            sendData = capitalizedSentence.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

            serverSocket.send(sendPacket);

        }
        serverSocket.close();
    }
}
