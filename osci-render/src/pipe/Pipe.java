package pipe;

import shapes.Shape;

import java.io.IOException;
import java.net.SocketException;
import java.util.List;

public class Pipe {
    private int defaultPort = 57480;
    private UDPConn conn;

    public Pipe() throws SocketException{
        this.conn = new UDPConn(defaultPort);
    }

    public Pipe(int port) throws SocketException {
        this.conn = new UDPConn(port);
    }

    // will block
    public List<Shape> getFrame() throws IOException {
        String json = conn.getData();
        List<Shape> decoded = Decoder.decodeFrame(json);
        return decoded;
    }
}
