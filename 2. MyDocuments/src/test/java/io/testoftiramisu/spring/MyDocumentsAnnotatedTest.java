package io.testoftiramisu.spring;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.java.service.SearchEngine;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MyDocumentsAnnotatedTest {

    List<Document> documents;
    private ApplicationContext context;
    private SearchEngine engine;
    private Type webType;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-annotations-context.xml");
        engine = context.getBean(SearchEngine.class);
        webType = context.getBean(Type.class);
    }

    @Test
    public void testFindByTypeWithAnnotations() {
        documents = engine.findByType(webType);
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(1);
    }

    @Test
    public void testFindByTypeValuesWithAnnotations() {
        documents = engine.findByType(webType);
        assertThat(documents).isNotNull();

        Type type = documents.get(0).getType();
        assertThat(type.getName()).isEqualTo(webType.getName());
        assertThat(type.getDescription()).isEqualTo(webType.getDescription());
        assertThat(type.getExtension()).isEqualTo(webType.getExtension());
    }


    @Test
    public void testListAllWithAnnotations() {
        documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);
    }
}
