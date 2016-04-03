import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Ксения on 4/3/2016.
 */
public class UDPServer {
    public static final int PORT = 6666;
    public static void main(String args[]) throws Exception
    {
        DatagramSocket serverSocket = new DatagramSocket(PORT);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String values = new String( receivePacket.getData());
            System.out.println("RECEIVED: " + values);
            if (values.startsWith("close connection")){
                System.out.println("close connection");
                break;
            }
            else {
                String[] val = values.split(" ");
                double fv = Double.valueOf(val[0]);
                double sv = Double.valueOf(val[1]);
                Results results = new Results(fv + sv, fv - sv, fv * sv, fv / sv);
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                String strResults = results.toString();
                sendData = strResults.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                serverSocket.send(sendPacket);
            }
        }
        serverSocket.close();
    }
}