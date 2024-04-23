import java.io.*;
import java.net.*;

public class VowelExtractorTCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12350);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String sentence = "Hello, how are you?"; // Input sentence for vowel extraction
        out.println(sentence);

        String response = in.readLine();
        System.out.println(response);

        in.close();
        out.close();
        socket.close();
    }
}
