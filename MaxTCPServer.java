import java.io.*;
import java.net.*;
import java.util.Arrays;

public class MaxTCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12349);
        System.out.println("Server started and listening on port 12349");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String numbers = in.readLine();
            if (numbers != null) {
                int max = Arrays.stream(numbers.split(","))
                                .mapToInt(Integer::parseInt)
                                .max()
                                .getAsInt();
                out.println("Maximum value is: " + max);
            }

            in.close();
            out.close();
            clientSocket.close();
        }
    }
}
