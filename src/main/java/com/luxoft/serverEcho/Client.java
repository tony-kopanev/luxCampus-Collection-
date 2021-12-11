package com.luxoft.serverEcho;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
  public static void main(String[] args) {

    try(Socket socket = new Socket("localhost", 3000);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();) {

      byte[] buffer = new byte[100];

      while (true) {
        // send test message
        String message = readClientInput(reader);

        outputStream.write(message.getBytes(StandardCharsets.UTF_8));
        System.out.println("Sending to server: " + message);

        // get answer from server
        int count = inputStream.read(buffer);
        String answerMess = new String(buffer, 0, count);
        System.out.println("Answer from server: " + answerMess);

//      outputStream.close();
//      inputStream.close();
      }
    } catch(IOException ex){
      ex.printStackTrace();
    }
  }

  static String readClientInput(BufferedReader bufferedReader) throws IOException {
    System.out.println("Hey user, give me some text!");
    String messageS = null;
    messageS = bufferedReader.readLine();
//    return bufferedReader.readLine();
    return messageS;
  }
//  15_01:04:26
}
