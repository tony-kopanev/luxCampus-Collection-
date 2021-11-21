package com.luxoft.IO;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class FileManager {
  public static int countFiles(String path){
    File curPath = new File(path);;
    int result = 0;
    if(Objects.requireNonNull(curPath.listFiles()).length == 0) return result;

    for(File curFile: Objects.requireNonNull(curPath.listFiles())){
      if(curFile.isDirectory())
        result += countFiles(curFile.getPath());
      else result++;
    }

    return result;
  }
}
