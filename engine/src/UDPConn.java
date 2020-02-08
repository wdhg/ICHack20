import java.io.IOException;
import java.net.*;

public class UDPConn {
    private final int defaultPort = 57480;
    private DatagramSocket socket;

    UDPConn() throws SocketException, UnknownHostException {
        this.socket = new DatagramSocket();
        this.socket.connect(InetAddress.getLocalHost(), defaultPort);
    }

    public void send(String json) throws IOException {
        DatagramPacket packet = new DatagramPacket(json.getBytes(), json.length());
        socket.send(packet);
    }
}
