import java.io.*;
import java.net.*;

public class FactorialUDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(12346);
        System.out.println("UDP server listening on port 12346");

        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
            socket.receive(request);

            String received = new String(request.getData(), 0, request.getLength());
            int number = Integer.parseInt(received);
            int factorial = calculateFactorial(number);

            String response = Integer.toString(factorial);
            DatagramPacket reply = new DatagramPacket(response.getBytes(), response.length(),request.getAddress(), request.getPort());
            socket.send(reply);
        }
    }

    private static int calculateFactorial(int num) {
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
