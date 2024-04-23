import java.io.*;
import java.net.*;

public class fibotcpserver {
    public static long fibo(int num) {
        if (num <= 1) {
            return num;
        } else {
            long a = 0;
            long b = 1;
            for (int i = 2; i <= num; i++) {
                long temp = a + b;
                a = b;
                b = temp;
            }
            return b;
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12347);
        System.out.println("Server is running...");

        while (true) {
            Socket clientSocket = serverSocket.accept(); // Accept incoming connections from clients
            System.out.println("Client connected: " + clientSocket);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            int num = Integer.parseInt(in.readLine());
            long result = fibo(num);

            out.println(result);

            clientSocket.close();
        }
    }
}
