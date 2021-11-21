package com.luxoft.IO;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileAnalyzerTest {
  // Кол-во вхождений искомого слова в файле
  // для тестов верну число
  @Test
  public void testCountMatches() throws IOException {
    File file = new File("src/test/resources/duck.txt");
    int actual = FileAnalyzer.countMatches(file, "duck");
    assertEquals(3, actual);
  }

  // Все предложения содержащие искомое слово
  @Test
  public void testMatchesSentences() throws IOException {
    File file = new File("src/test/resources/duck.txt");
    String[] actual = FileAnalyzer.matchesSentences(file, "duck");
    assertNotNull(actual);

    String[] expected = new String[]{
      "Test duck 1?",
      "Test duck 2!",
      "Test duck 3."
    };
    assertEquals(expected[0], actual[0]);
    assertEquals(expected[1], actual[1]);
    assertEquals(expected[2], actual[2]);
    assertArrayEquals(expected, actual);
  }
}
