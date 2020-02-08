import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPConn {
    private final int bufLen = 1024;
    private final int defaultPort = 57480;
    private DatagramSocket socket;

    UDPConn() throws SocketException {
        this(57480);
    }

    UDPConn(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
    }

    public void send(String json) throws IOException {
        DatagramPacket packet = new DatagramPacket(json.getBytes(), json.length());
        socket.send(packet);
    }
}
