package io.testoftiramisu.spring.test;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.java.service.SearchEngine;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyDocumentsTest {
    private SearchEngine engine;
    private Type webType;

    @Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-context.xml");
        engine = context.getBean(SearchEngine.class);
        webType = context.getBean("webType", Type.class);
    }

    @Test
    public void testWithSpringFindByType() {
        List<Document> documents = engine.findByType(webType);
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(1);

        Type actualType = documents.get(0).getType();
        assertThat(actualType.getName()).isEqualTo(webType.getName());
        assertThat(actualType.getDescription()).isEqualTo(webType.getDescription());
        assertThat(actualType.getExtension()).isEqualTo(webType.getExtension());

    }

    @Test
    public void listAllShouldReturnFourDocumentTypes() throws Exception {
        List<Document> documents = engine.listAll();
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(4);
    }

}
