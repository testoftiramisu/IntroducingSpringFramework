package io.testoftiramisu.spring.annotated.service;

import io.testoftiramisu.spring.data.DocumentDAO;
import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.java.service.SearchEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("engine")
public class AnnotatedSearchEngine implements SearchEngine {

    @Autowired
    private DocumentDAO documentDAO;

    @Override
    public List<Document> findByType(Type documentType) {
        List<Document> result = new ArrayList<>();
        for (Document document : listAll()) {
            if (document.getType().getName().equals(documentType.getName())) {
                result.add(document);
            }
        }
        return result;
    }

    @Override
    public List<Document> listAll() {
        return Arrays.asList(documentDAO.getAll());
    }
}
