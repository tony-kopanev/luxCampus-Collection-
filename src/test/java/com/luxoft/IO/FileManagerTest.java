package com.luxoft.IO;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTest {
  @Test
  public void testCountFiles(){
    int actual = FileManager.countFiles("src/test/resources");
    assertEquals(7, actual);
  }

  @Test
  public void testCountDirs(){
    int actual = FileManager.countDirs("src/test/resources");
    assertEquals(3, actual);
  }
}
