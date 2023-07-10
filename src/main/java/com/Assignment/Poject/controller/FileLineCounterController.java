package com.Assignment.Poject.controller;

import com.Assignment.Poject.service.FileLineCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FileLineCounterController {
    private final FileLineCounterService fileLineCounterService;

    @Autowired
    public FileLineCounterController(FileLineCounterService fileLineCounterService) {
        this.fileLineCounterService = fileLineCounterService;
    }

    @PostMapping("/count-lines")
    public String countLines(@RequestBody String[] filenames) {
        StringBuilder result = new StringBuilder();

        for (String filename : filenames) {
            int lineCount = fileLineCounterService.countLines(filename);
            result.append(filename).append(": ").append(lineCount).append(" lines\n");
        }

        return result.toString();
    }
}
