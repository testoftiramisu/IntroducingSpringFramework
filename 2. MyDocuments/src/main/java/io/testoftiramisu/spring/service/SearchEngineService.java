package io.testoftiramisu.spring.service;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.java.service.SearchEngine;
import io.testoftiramisu.spring.data.DocumentDAO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchEngineService implements SearchEngine {
    private DocumentDAO documentDAO;

    public SearchEngineService() {
    }

    public DocumentDAO getDocumentDAO() {
        return documentDAO;
    }

    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    @Override
    public List<Document> findByType(Type documentType) {
        return listAll().stream()
                .filter(document -> document.getType().getName().equals(documentType.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Document> listAll() {
        return Arrays.asList(documentDAO.getAll());
    }

    @Override
    public List<Document> findByLocation(String location) {
        throw new UnsupportedOperationException("find location not yet implemented");
    }
}
