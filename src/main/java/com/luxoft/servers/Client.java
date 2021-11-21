package com.luxoft.servers;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("localhost", 3000);
    InputStream inputStream = socket.getInputStream();

    byte[] buffer = new byte[100];
    int count = inputStream.read(buffer);
    System.out.println(new String(buffer, 0 , count));
  }
}
