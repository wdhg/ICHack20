package pipe;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPConn {
    private int bufLen = 1024;
    private DatagramSocket socket;
    private byte[] buf = new byte[bufLen];

    UDPConn(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
    }

    // blocks
    String getData() throws IOException {
        DatagramPacket packet = new DatagramPacket(buf,bufLen);
        System.out.println("blocking");
        this.socket.receive(packet);
        System.out.println(new String(packet.getData()));
        return new String(packet.getData());
    }

}
