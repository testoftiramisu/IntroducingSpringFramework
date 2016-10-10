package io.testoftiramisu.spring.service;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.java.service.SearchEngine;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("qa")
public class FileSearchEngineService implements SearchEngine {

    @Override
    public List<Document> findByType(Type documentType) {
        throw new UnsupportedOperationException("QA Environment. Not yet implemented operation.");
    }

    @Override
    public List<Document> listAll() {
        throw new UnsupportedOperationException("QA Environment. Not yet implemented operation.");
    }

    @Override
    public List<Document> findByLocation(String location) {
        throw new UnsupportedOperationException("find location not yet implemented");
    }
}
