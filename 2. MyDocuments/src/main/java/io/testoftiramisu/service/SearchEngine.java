package io.testoftiramisu.service;

import io.testoftiramisu.model.Document;
import io.testoftiramisu.model.Type;

import java.util.List;

public interface SearchEngine {
    List<Document> findByType(Type documentType);
    List<Document> listAll();
}
