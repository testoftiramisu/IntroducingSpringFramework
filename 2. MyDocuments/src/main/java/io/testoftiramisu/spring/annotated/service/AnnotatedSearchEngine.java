package io.testoftiramisu.spring.annotated.service;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.java.service.SearchEngine;
import io.testoftiramisu.spring.data.DocumentDAO;
import io.testoftiramisu.spring.service.SearchEngineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Example of context configuration with help of Annotations
@Service("engine")
@Scope("prototype")
public class AnnotatedSearchEngine implements SearchEngine {
    private static final Logger log = LoggerFactory.getLogger(SearchEngineService.class);


    @Autowired
    private DocumentDAO documentDAO;

    public AnnotatedSearchEngine() {
        if (log.isDebugEnabled()) {
            log.debug("Annotated Search Engine created: " + this);
        }
    }

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
        return documentDAO.getAll();
    }

    @Override
    public List<Document> findByLocation(String location) {
        throw new UnsupportedOperationException("find location not yet implemented");
    }
}
