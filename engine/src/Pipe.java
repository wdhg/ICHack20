import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

public class Pipe {
    TCPConn conn;

    Pipe() throws IOException {
        this.conn = new TCPConn();
    }
    public void send(List<Vector2> vertices, List<Integer> connections) throws IOException {
        String json = Encoder.encode(vertices, connections);
        conn.send(json);
    }
}
