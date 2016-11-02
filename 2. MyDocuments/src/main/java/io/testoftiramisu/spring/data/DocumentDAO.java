package io.testoftiramisu.spring.data;

import io.testoftiramisu.java.model.Document;

import java.util.List;

public interface DocumentDAO {
    List<Document> getAll();
    void save(Document document);
}
