package pipe;

import shapes.Shape;

import java.io.IOException;
import java.net.SocketException;
import java.util.List;

public class Pipe {
    private int defaultPort = 57480;
    private UDPConn conn;
    Pipe() throws SocketException{
        this.conn = new UDPConn(defaultPort);
    }

    Pipe(int port) throws SocketException {
        this.conn = new UDPConn(port);
    }

    // will block
    public List<Shape> getFrame() throws IOException {
        String json = conn.getData();
        return Decoder.decodeFrame(json);
    }
}
