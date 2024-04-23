import java.io.*;
import java.net.*;

public class IntegerReversalTCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12348);
        System.out.println("Server started and listening on port 12348");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine = in.readLine();
            if (inputLine != null) {
                String reversed = new StringBuilder(inputLine).reverse().toString();
                out.println(reversed);
            }

            in.close();
            out.close();
            clientSocket.close();
        }
    }
}
