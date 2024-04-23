import java.io.*;
import java.net.*;

public class MaxElementClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        Socket socket = new Socket("localhost", 12348);

        int[] array = {5, 3, 9, 7, 2};
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        objectOutputStream.writeObject(array);
        int max = (int) objectInputStream.readObject();
        System.out.println("Maximum element in the array: " + max);

        socket.close();
        
    }
}
