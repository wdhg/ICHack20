import java.io.IOException;
import java.net.SocketException;
import java.util.List;

public class Pipe {
    UDPConn conn;

    Pipe() throws SocketException {
        this.conn = new UDPConn();
    }
    public void send(List<Vector2> vertices, int[] connections) throws IOException {
        String json = Encoder.encode(vertices, connections);
        conn.send(json);
    }
}
