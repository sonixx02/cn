import java.io.*;
import java.net.*;

public class VowelExtractorUDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");
        int serverPort = 12347;

        String sentence = "Hello, how are you?"; // Input sentence for vowel extraction
        byte[] sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
        socket.send(sendPacket);

        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);

        String vowels = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Vowels extracted from the sentence: " + vowels);

        socket.close();
    }
}
