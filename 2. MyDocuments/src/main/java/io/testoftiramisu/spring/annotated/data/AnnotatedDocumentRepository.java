package io.testoftiramisu.spring.annotated.data;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.spring.data.DocumentDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class AnnotatedDocumentRepository implements DocumentDAO {

    @Override
    public List<Document> getAll() {
        return Arrays.asList(storage());
    }

    private Document[] storage() {
        List<Document> result = new ArrayList<>();

        Type type = new Type();
        type.setName("PDF");
        type.setDescription("Portable Document format");
        type.setExtension(".pdf");

        Document document = new Document();
        document.setName("Book Template");
        document.setType(type);
        document.setLocation("/Users/Tiramisu/Documents/tmp/Book Template.pdf");
        result.add(document);

        document = new Document();
        document.setName("Sample contract");
        document.setType(type);
        document.setLocation("/Users/Tiramisu/Documents/tmp/Sample Contract.pdf");
        result.add(document);

        type = new Type();
        type.setName("NOTE");
        type.setDescription("Text Notes");
        type.setExtension(".txt");

        document = new Document();
        document.setName("Clustering with RabbitMQ");
        document.setType(type);
        document.setLocation("/Users/Tiramisu/Documents/tmp/Clustering with RabbitMQ.txt");
        result.add(document);

        type = new Type();
        type.setName("WEB");
        type.setDescription("Web Link");
        type.setExtension(".url");

        document = new Document();
        document.setName("Pro Spring Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");
        result.add(document);

        return result.toArray(new Document[result.size()]);
    }


}
