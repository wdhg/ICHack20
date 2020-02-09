package pipe;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;

public class TCPConn {
    private final int defaultPort = 57480;
    private Socket socket;

    TCPConn() throws IOException {
        this.socket = new Socket("localhost", defaultPort);
    }

    public void send(String json) throws IOException {
        byte[] jsonB = json.getBytes();
        int len = jsonB.length;
        byte[] lenB = new byte[4];
        lenB[0] = ((byte) (len >> 24));
        lenB[0] &= 0xFF;
        lenB[1] = ((byte) (len >> 16));
        lenB[1] &= 0xFF;
        lenB[2] = ((byte) (len >> 8));
        lenB[2] &= 0xFF;
        lenB[3] = ((byte) (len));
        lenB[3] &= 0xFF;
        byte[] c = new byte[4 + jsonB.length];
        System.arraycopy(lenB, 0, c, 0, 4);
        System.arraycopy(jsonB, 0, c, 4, jsonB.length);
        socket.getOutputStream().write(c);
    }
}