package pipe;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Arrays;

public class TCPConn {
  private int bufLen = 1024000;
  private Socket socket;
  private byte[] buf = new byte[bufLen];
  private InputStream input;

  TCPConn(int port) throws IOException {
    ServerSocket listener = new ServerSocket(port);
    this.socket = listener.accept();
    input = socket.getInputStream();
  }

  // blocks
  String getData() throws IOException {
    byte[] lenB = new byte[4];
    input.read(lenB);
    int len = ((lenB[0] & 0xFF) << 24) + ((lenB[1] & 0xFF) << 16) + ((lenB[2] & 0xFF) << 8) + (lenB[3] & 0xFF);

    int pointer = 0;
    for (; pointer < len;) {
      int red = input.read(buf, pointer, len - pointer);
      pointer += red;
    }


    return new String(Arrays.copyOf(buf, len));
  }

}
