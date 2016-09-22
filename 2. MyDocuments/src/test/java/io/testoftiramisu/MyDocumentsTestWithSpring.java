package io.testoftiramisu;


import io.testoftiramisu.model.Document;
import io.testoftiramisu.model.Type;
import io.testoftiramisu.service.SearchEngine;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyDocumentsTestWithSpring {

    private SearchEngine engine;
    private Type TypeFromSpringContext;
    private Type actualType;
    List<Document> foundedDocuments;


    @Before
    public void setDocumentTypeWithSpringContext() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-context.xml");
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
