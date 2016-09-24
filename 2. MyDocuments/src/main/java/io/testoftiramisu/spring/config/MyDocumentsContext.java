package io.testoftiramisu.spring.config;


import io.testoftiramisu.spring.data.DocumentRepository;
import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.java.service.SearchEngine;
import io.testoftiramisu.spring.data.DocumentDAO;
import io.testoftiramisu.spring.service.SearchEngineService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

// Java bean Configuration example
@Configuration
public class MyDocumentsContext {

    private Map<String, Document> documents = new HashMap<>();
    private Map<String, Type> types = new HashMap<>();

    public MyDocumentsContext() {

        Type type = new Type();
        type.setName("PDF");
        type.setDescription("Portable Document format");
        type.setExtension(".pdf");

        Document document = new Document();
        document.setName("Book Template");
        document.setType(type);
        document.setLocation("/Users/Tiramisu/Documents/tmp/Book Template.pdf");

        documents.put("doc1", document);
        types.put("pdf", type);

        document = new Document();
        document.setName("Sample contract");
        document.setType(type);
        document.setLocation("/Users/Tiramisu/Documents/tmp/Sample Contract.pdf");

        documents.put("doc2", document);

        type = new Type();
        type.setName("NOTE");
        type.setDescription("Text Notes");
        type.setExtension(".txt");

        document = new Document();
        document.setName("Clustering with RabbitMQ");
        document.setType(type);
        document.setLocation("/Users/Tiramisu/Documents/tmp/Clustering with RabbitMQ.txt");

        documents.put("doc3", document);
        types.put("note", type);

        type = new Type();
        type.setName("WEB");
        type.setDescription("web link");
        type.setExtension(".url");

        document = new Document();
        document.setName("Pro Spring Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");

        documents.put("doc4", document);
        types.put("web", type);
    }

    @Bean
    public Type webType() {
        return getTypeFromMap("web");
    }

    @Bean
    public SearchEngine engine() {
        SearchEngineService engine = new SearchEngineService();
        engine.setDocumentDAO(documentDAO());
        return engine;
    }

    private DocumentDAO documentDAO() {
        DocumentRepository documentDAO = new DocumentRepository();
        documentDAO.setDocument1(getDocumentFromMap("doc1"));
        documentDAO.setDocument2(getDocumentFromMap("doc2"));
        documentDAO.setDocument3(getDocumentFromMap("doc3"));
        documentDAO.setDocument4(getDocumentFromMap("doc4"));
        return documentDAO;
    }

    private Document getDocumentFromMap(String documentKey) {
        return documents.get(documentKey);
    }

    private Type getTypeFromMap(String typeKey) {
        return types.get(typeKey);
    }


}
