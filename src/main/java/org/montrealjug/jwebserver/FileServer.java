package org.montrealjug.jwebserver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.io.FileReader;
 
import com.sun.net.httpserver.SimpleFileServer; 
import com.sun.net.httpserver.SimpleFileServer.OutputLevel; 

// copied from: https://marco.dev/java-18-web-server
public class FileServer {
  public static void main(String[] args) {
    // parameters 
    Integer port = 8080; 
    String pathToServe = "/"; 
    OutputLevel outputLevel = OutputLevel.VERBOSE;

    // create the server
    var server = SimpleFileServer.createFileServer( 
      new InetSocketAddress(port), 
      Path.of(pathToServe), 
      outputLevel); 
 
      // start the server 
      server.start(); 
  }

  static {
    // always uses UTF-8 by default
    try (var fileReader = new FileReader("README.md")){
      var stringBuilder = new StringBuilder();
      var buffer = new char[10];
      while (fileReader.read(buffer) != -1) {
        stringBuilder.append(new String(buffer));
        buffer = new char[10];
      }
      System.out.println(stringBuilder);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
} 