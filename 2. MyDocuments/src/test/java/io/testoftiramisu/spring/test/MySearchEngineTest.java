package io.testoftiramisu.spring.test;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.java.service.MySearchEngine;
import io.testoftiramisu.java.service.SearchEngine;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MySearchEngineTest {
    List<Document> documents;
    private SearchEngine engine = new MySearchEngine();
    private Type documentType = new Type();

    @Before
    public void setDocumentTypeToWeb() {
        documentType.setName("WEB");
        documentType.setDescription("Web Link");
        documentType.setExtension(".url");
    }

    @Test
    public void documentCouldBeFoundByType() {
        documents = engine.findByType(documentType);
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(1);
    }

    @Test
    public void nameOfFoundTypeIsCorrect() {
        documents = engine.findByType(documentType);
        Type type = documents.get(0).getType();
        assertThat(type.getName()).isEqualTo(documentType.getName());
    }

    @Test
    public void descriptionOfFoundedTypeIsCorrect() {
        documents = engine.findByType(documentType);
        Type type = documents.get(0).getType();
        assertThat(type.getDescription()).isEqualTo(documentType.getDescription());
    }

    @Test
    public void extensionOfFoundedTypeIsCorrect() {
        documents = engine.findByType(documentType);
        Type type = documents.get(0).getType();
        assertThat(type.getExtension()).isEqualTo(documentType.getExtension());
    }

    @Test
    public void listAllReturnFourDocumentTypes() throws Exception {
        List<Document> documents = engine.listAll();
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(4);
    }
}