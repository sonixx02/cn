import java.io.*;
import java.net.*;

public class IntegerReversalTCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12348);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        int number = 12345; // Input integer for reversal
        out.println(Integer.toString(number));

        String reversed = in.readLine();
        System.out.println("Reversed integer: " + reversed);

        in.close();
        out.close();
        socket.close();
    }
}
