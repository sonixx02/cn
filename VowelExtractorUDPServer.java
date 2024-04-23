import java.io.*;
import java.net.*;

public class VowelExtractorUDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(12347);
        System.out.println("UDP server listening on port 12347");

        while (true) {
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());

            String vowels = extractVowels(sentence);

            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            byte[] sendData = vowels.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            socket.send(sendPacket);
        }
    }

    private static String extractVowels(String sentence) {
        return sentence.replaceAll("[^aeiouAEIOU]", "");
    }
}

