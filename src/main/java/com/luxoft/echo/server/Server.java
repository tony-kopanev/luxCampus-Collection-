package com.luxoft.echo.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException {

    try(    ServerSocket serverSocket = new ServerSocket(3000);
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){
      while (true){
        // get test message
        String message = "echo: " + bufferedReader.readLine() + "\n";

        bufferedWriter.write(message);
        bufferedWriter.flush();
      }
    }
  }
}
