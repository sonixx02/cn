import java.io.*;
import java.net.*;

public class arrayservertcp {
    public static void main(String[] args)throws IOException, ClassNotFoundException {
        ServerSocket serversocket = new ServerSocket(12348);
        System.out.println("connected server");

        while(true){
            Socket socket = serversocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            int[] array = (int[]) objectInputStream.readObject();
            int max = findMaxElement(array);
            objectOutputStream.writeObject(max);
        }
    }

    private static int findMaxElement(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
