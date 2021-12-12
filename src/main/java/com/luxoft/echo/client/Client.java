package com.luxoft.echo.client;

import java.io.*;
import java.net.Socket;

public class Client {
  public static void main(String[] args) {

    try(Socket socket = new Socket("localhost", 3000);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {


      while (true) {
        // send test message
        String message = readClientInput(reader);

        bufferedWriter.write(message);
        bufferedWriter.flush();
        System.out.println("Sending to server: " + message);

        // get answer from server
        String answerMess = bufferedReader.readLine();
        System.out.println("Answer from server: " + answerMess);
      }
    } catch(IOException ex){
      ex.printStackTrace();
    }
  }

  static String readClientInput(BufferedReader bufferedReader) throws IOException {
    System.out.println("Hey user, give me some text!");
    String messageS = null;
    messageS = bufferedReader.readLine() + "\n";
//    return bufferedReader.readLine();
    return messageS;
  }
}
