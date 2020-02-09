package pipe;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPConn {
    private int bufLen = 10240;
    private DatagramSocket socket;
    private byte[] buf = new byte[bufLen];

    UDPConn(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
    }

    // blocks
    String getData() throws IOException {
        DatagramPacket packet = new DatagramPacket(buf,bufLen);
        this.socket.receive(packet);
        return new String(packet.getData());
    }

}
