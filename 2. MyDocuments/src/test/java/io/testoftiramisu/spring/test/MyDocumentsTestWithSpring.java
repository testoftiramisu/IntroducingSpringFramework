package io.testoftiramisu.spring.test;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.java.service.SearchEngine;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyDocumentsTestWithSpring {

    List<Document> foundedDocuments;
    private SearchEngine engine;
    private Type TypeFromSpringContext;
    private Type actualType;

    @Before
    public void setDocumentTypeWithSpringContext() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-context-old.xml");
        engine = context.getBean(SearchEngine.class);
        TypeFromSpringContext = context.getBean(Type.class);

        foundedDocuments = engine.findByType(TypeFromSpringContext);
        actualType = foundedDocuments.get(0).getType();
    }

    @Test
    public void documentCouldBeFoundByType() {
        assertThat(foundedDocuments).isNotNull();
        assertThat(foundedDocuments).hasSize(1);
    }

    @Test
    public void nameOfFoundTypeIsCorrect() {
        assertThat(actualType.getName()).isEqualTo(TypeFromSpringContext.getName());
    }

    @Test
    public void descriptionInFoundedTypeIsCorrect() {
        assertThat(actualType.getDescription()).isEqualTo(TypeFromSpringContext.getDescription());
    }

    @Test
    public void extensionInFoundedTypeIsCorrect() {
        assertThat(actualType.getExtension()).isEqualTo(TypeFromSpringContext.getExtension());
    }

    @Test
    public void listAllReturnFourDocumentTypes() throws Exception {
        List<Document> documents = engine.listAll();
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(4);
    }


}
