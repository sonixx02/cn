import java.io.*;
import java.net.*;

public class FactorialUDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");
        int serverPort = 12346;

        int number = 5; // Input number for factorial calculation
        byte[] sendData = Integer.toString(number).getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
        socket.send(sendPacket);

        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);

        String factorialStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
        int factorial = Integer.parseInt(factorialStr);
        System.out.println("Factorial of " + number + " is: " + factorial);

        socket.close();
    }
}

