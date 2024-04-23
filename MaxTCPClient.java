import java.io.*;
import java.net.*;
import java.util.Arrays;

public class MaxTCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12349);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        int[] array = {10, 5, 8, 20, 15}; // Input array for finding maximum
        String arrayStr = Arrays.toString(array);
        out.println(arrayStr.substring(1, arrayStr.length() - 1).replace(" ", ""));

        String response = in.readLine();
        System.out.println(response);

        in.close();
        out.close();
        socket.close();
    }
}
