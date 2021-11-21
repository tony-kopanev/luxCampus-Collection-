package com.luxoft.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringJoiner;

public class FileAnalyzer {
  public static void main(String[] args) throws IOException {
    File file = new File("src/test/resources/duck.txt");
    matchesSentences(file, "duck");
  }

  // Кол-во вхождений искомого слова в файле
  public static int countMatches(File file, String matchWord) throws IOException {
    FileInputStream fileInputStream = new FileInputStream(file);

    StringJoiner strResult = new StringJoiner("");
    while (fileInputStream.available() > 0){
      char curChar = (char) fileInputStream.read();
      strResult.add(String.valueOf(curChar));
    }

    fileInputStream.close();
    int result = (int) Arrays.stream(strResult.toString().split(" "))
            .filter(str -> str.equals(matchWord))
            .count();

    // выводим на экран результат
    System.out.println(result);
    // возвращаем его для тестов
    return result;
  }

  //Все предложения содержащие искомое слово
  public static String[] matchesSentences(File file, String matchWord) throws IOException {
    FileInputStream fileInputStream = new FileInputStream(file);

    StringJoiner allText = new StringJoiner("");
    while (fileInputStream.available() > 0){
      char curChar = (char) fileInputStream.read();
      allText.add(String.valueOf(curChar));
    }
    fileInputStream.close();

    // выводим на экран
    Arrays.stream(allText.toString().split("\n"))
            .filter(str -> str.contains(matchWord))
            .forEach(System.out::println);

    // возвращаем массив для тестов
    return Arrays.stream(allText.toString().split("\n"))
            .filter(str -> str.contains(matchWord))
            .toArray(String[]::new);
  }
}
