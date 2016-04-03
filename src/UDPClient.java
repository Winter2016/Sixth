import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Ксения on 4/3/2016.
 */
public class UDPClient {
    public static final int PORT = 6666;
    public static void main(String args[]) throws Exception    {
        DatagramSocket clientSocket = null;
        InetAddress IPAddress = null;
        for(int i=0; i<5;i++) {
            double fv = i + 3;
            double sv = i;
            String values = fv + " " + sv;
            clientSocket = new DatagramSocket();
            IPAddress = InetAddress.getByName("localhost");
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            if (i == 4) {
                String str = "close connection";
                sendData = str.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, PORT);
                clientSocket.send(sendPacket);}
            else {
                sendData = values.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, PORT);
                clientSocket.send(sendPacket);
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String results = new String(receivePacket.getData());
                System.out.println(results);
            }
            clientSocket.close();
        }
    }
}
