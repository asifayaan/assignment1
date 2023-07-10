package com.Assignment.Poject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLineCounter implements Runnable {
    private String filename;
    private StringBuilder result;

    public FileLineCounter(String filename, StringBuilder result) {
        this.filename = filename;
        this.result = result;
    }

    @Override
    public void run() {
        try {
            int lineCount = countLines(filename);
            result.append(filename).append(": ").append(lineCount).append(" lines\n");
        } catch (IOException e) {
            result.append("Error reading file: ").append(filename).append("\n");
        }
    }

    private int countLines(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int lineCount = 0;
        while (reader.readLine() != null) {
            lineCount++;
        }
        reader.close();
        return lineCount;
    }
}
