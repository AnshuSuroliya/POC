package com.poc.buddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Controller {
    @Autowired
    ElasticSearch elasticSearch;
    @GetMapping("/get")
    public Product get() throws IOException {
        return elasticSearch.get();
    }
}
