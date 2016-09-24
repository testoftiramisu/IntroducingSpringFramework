package io.testoftiramisu.java.service;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MySearchEngine implements SearchEngine {

// Old school way to filter results:
//    public List<Document> findByType(Type documentType) {
//        List<Document> result = new ArrayList<>();
//        for (Document document : storage()) {
//            if (document.getType().getName().equals(documentType.getName())) {
//                result.add(document);
//            }
//        }
//        return result;
//    }

    @Override
    public List<Document> findByType(Type documentType) {
        return storage().stream().filter(document -> document.getType().getName().equals(documentType.getName())).collect(Collectors.toList());
    }

    @Override
    public List<Document> listAll() {
        return storage();
    }

    private List<Document> storage() {
        List<Document> result = new ArrayList<>();

        Type type = new Type();
        type.setName("PDF");
        type.setDescription("Portable Document Format");
        type.setExtension(".pdf");

        Document document = new Document();
        document.setName("Book Template");
        document.setType(type);
        document.setLocation("/Documents/Book Template.pdf");
        result.add(document);

        // URL document type
        type = new Type();
        type.setName("WEB");
        type.setDescription("Web Link");
        type.setExtension(".url");

        document = new Document();
        document.setName("URL Template");
        document.setType(type);
        document.setLocation("/Documents/URL Template.url");
        result.add(document);

        // Word file document type
        type = new Type();
        type.setName("WORD");
        type.setDescription("MS Word document");
        type.setExtension(".doc");

        document = new Document();
        document.setName("Word Template");
        document.setType(type);
        document.setLocation("/Documents/Word Template.doc");
        result.add(document);

        // Notes document type
        type = new Type();
        type.setName("Markdown");
        type.setDescription("Markdown document");
        type.setExtension(".md");

        document = new Document();
        document.setName("Markdown Template");
        document.setType(type);
        document.setLocation("/Documents/Markdown Template.md");
        result.add(document);

        return result;
    }

}
