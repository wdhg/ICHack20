import java.io.IOException;
import java.net.*;

public class TCPConn {
    private final int defaultPort = 57480;
    private Socket socket;

    TCPConn() throws IOException {
        this.socket = new Socket();
        this.socket.connect(socket.getLocalSocketAddress(), defaultPort);
    }

    public void send(String json) throws IOException {
        byte[] jsonB = json.getBytes();
        int len = jsonB.length;
        byte[] lenB = new byte[]{
                (byte) (len >>> 8),
                (byte) (len)
        };
        byte[] c = new byte[2 + jsonB.length];
        System.arraycopy(lenB, 0, c, 0, 2);
        System.arraycopy(jsonB, 0, c, 2, jsonB.length);
        socket.getOutputStream().write(c);
    }
}
