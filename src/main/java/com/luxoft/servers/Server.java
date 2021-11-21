package com.luxoft.servers;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class Server {
  public static void main(String[] args) throws IOException {
    while (true){
      ServerSocket serverSocket = new ServerSocket(3000);
      Socket socket = serverSocket.accept();
      String message = "Hello amigo, current time: " + LocalDateTime.now();

      OutputStream outputStream = socket.getOutputStream();
      outputStream.write(message.getBytes(StandardCharsets.UTF_8));
    }
  }
}
