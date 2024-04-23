import java.net.*;
import java.io.*;

public class fibotcpclient{
    public static void main(String[] args)throws IOException {
        Socket socket = new Socket("localhost",12347);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        int num = 6;
        out.println(Integer.toString(num));
        long result = Long.parseLong(in.readLine());
        System.out.println("Fibonacci(" + num + ") = " + result);
            
        socket.close();

    }
}
