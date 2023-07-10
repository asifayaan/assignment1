
//
//import org.springframework.stereotype.Service;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//@Service
//public class FileLineCounterService {
//    public int countLines(String filename) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader(filename));
//        int lineCount = 0;
//        while (reader.readLine() != null) {
//            lineCount++;
//        }
//        reader.close();
//        return lineCount;
//    }
//}

package com.Assignment.Poject.service;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class FileLineCounterService {
    public int countLines(String filename) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
            if (inputStream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                int lineCount = 0;
                while (reader.readLine() != null) {
                    lineCount++;
                }
                reader.close();
                return lineCount;
            } else {
                throw new IllegalArgumentException("File not found: " + filename);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filename, e);
        }
    }
}
