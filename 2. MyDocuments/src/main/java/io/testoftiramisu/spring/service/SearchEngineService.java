package io.testoftiramisu.spring.service;

import io.testoftiramisu.java.service.SearchEngine;
import io.testoftiramisu.spring.data.DocumentDAO;
import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchEngineService implements SearchEngine {
    private static final Logger log = LoggerFactory.getLogger(SearchEngineService.class);

    private DocumentDAO documentDAO;

    public SearchEngineService() {
        if (log.isDebugEnabled()) {
            log.debug("Search Engine Service created " + this);
        }
    }

    public DocumentDAO getDocumentDAO() {
        return documentDAO;
    }

    public void setDocumentDAO(DocumentDAO documentDAO) {
        if (log.isDebugEnabled()) {
            log.debug("Document DAO set: " + documentDAO);
        }
        this.documentDAO = documentDAO;
    }

    @Override
    public List<Document> findByType(Type documentType) {
        return listAll().stream().filter(document -> document.getType().getName().equals(documentType.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Document> listAll() {
        return Arrays.asList(documentDAO.getAll());
    }
}
