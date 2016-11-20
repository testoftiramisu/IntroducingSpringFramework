package io.testoftiramisu.java.service;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;

import java.util.List;

public interface SearchEngine {
    List<Document> findByType(Type documentType);

    List<Document> listAll();

    List<Document> findByLocation(String location);

    Document findById(String id);
}
