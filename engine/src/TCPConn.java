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
        byte[] lenB = new byte[2];
        lenB[0] = ((byte) (len >> 8));
        lenB[0] &= 0xFF;
        lenB[1] = ((byte) (len));
        lenB[1] &= 0xFF;
        byte[] c = new byte[2 + jsonB.length];
        System.arraycopy(lenB, 0, c, 0, 2);
        System.arraycopy(jsonB, 0, c, 2, jsonB.length);
        socket.getOutputStream().write(c);
    }
}
