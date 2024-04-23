import java.io.*;
import java.net.*;

public class VowelExtractorTCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12350);
        System.out.println("Server started and listening on port 12350");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String sentence = in.readLine();
            if (sentence != null) {
                String vowels = extractVowels(sentence);
                out.println("Vowels in the string: " + vowels);
            }

            in.close();
            out.close();
            clientSocket.close();
        }
    }

    private static String extractVowels(String sentence) {
        return sentence.replaceAll("[^aeiouAEIOU]", "");
    }
}
