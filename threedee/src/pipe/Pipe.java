package pipe;

import java.io.IOException;

public class Pipe {
    TCPConn conn;

    public Pipe() throws IOException {
        this.conn = new TCPConn();
    }
    public void send(String json) throws IOException {
        conn.send(json);
    }
}