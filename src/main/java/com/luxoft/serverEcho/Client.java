package com.luxoft.serverEcho;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("localhost", 3000);

    // send test message
    OutputStream outputStream = socket.getOutputStream();
    String message = "Some, awesome test message";
    outputStream.write(message.getBytes(StandardCharsets.UTF_8));

    // get answer from server
    InputStream inputStream = socket.getInputStream();
    byte[] buffer = new byte[100];
    int count = inputStream.read(buffer);
    System.out.println(new String(buffer, 0, count));
  }
}
