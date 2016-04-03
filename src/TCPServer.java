import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Ксения on 4/1/2016.
 */
public class TCPServer {
    public static final int PORT = 7777;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("open port ---> " + PORT);
        ServerSocket serverSocket = new ServerSocket(PORT);
        while(true) {
            System.out.println("listen for incoming connections");
            Socket socket = serverSocket.accept();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            String values = (String) inputStream.readObject();
            if (values.equalsIgnoreCase("close connection")) {
                System.out.println("close connection");
                break;
            }
            else {
                String[] val = values.split(" ");
                double fv = Double.valueOf(val[0]);
                double sv = Double.valueOf(val[1]);
                Results results = new Results(fv + sv, fv - sv, fv * sv, fv / sv);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(results);

                inputStream.close();
                objectOutputStream.close();
                socket.close();
            }
        }
        serverSocket.close();
    }
}

