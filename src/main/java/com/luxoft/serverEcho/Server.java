package com.luxoft.serverEcho;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
  public static void main(String[] args) throws IOException {
    while (true){
      ServerSocket serverSocket = new ServerSocket(3000);
      Socket socket = serverSocket.accept();

      // get test message
      InputStream inputStream = socket.getInputStream();
      byte[] buffer = new byte[100];
      int count = inputStream.read(buffer);
      String message = "echo: " + new String(buffer, 0, count);

      // send answer message, with prefix "echo"
      OutputStream outputStream = socket.getOutputStream();
      outputStream.write(message.getBytes(StandardCharsets.UTF_8));
    }
  }
}
