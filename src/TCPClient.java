import java.io.*;
import java.net.Socket;

/**
 * Created by Ксения on 4/1/2016.
 */
public class TCPClient {
    public static final String HOST = "localhost";
    public static final int PORT = 7777;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = null;
        OutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        for(int i=0; i<5;i++) {
            socket = new Socket(HOST, PORT);
            outputStream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            double fv = i + 3;
            double sv = i;
            String values = fv + " " + sv;
            if (i == 4)
                objectOutputStream.writeObject("close connection");
            else {
                objectOutputStream.writeObject(values);
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                Results results = (Results) objectInputStream.readObject();
                System.out.println(results.toString());
                objectInputStream.close();
            }
            objectOutputStream.close();
            outputStream.close();
            socket.close();
        }
    }
}
