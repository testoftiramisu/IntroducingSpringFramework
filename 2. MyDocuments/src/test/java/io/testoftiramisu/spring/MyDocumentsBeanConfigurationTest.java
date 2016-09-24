package io.testoftiramisu.spring;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.java.service.SearchEngine;
import io.testoftiramisu.spring.config.MyDocumentsContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyDocumentsBeanConfigurationTest {

    List<Document> documents;
    private ApplicationContext context;
    private SearchEngine engine;
    private Type webType;

    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext(MyDocumentsContext.class);
        engine = context.getBean(SearchEngine.class);
        webType = context.getBean(Type.class);
    }

    @Test
    public void testFindByTypeWithBeanConfiguration() {
        documents = engine.findByType(webType);
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(1);

        Type actualType = documents.get(0).getType();

        assertThat(actualType.getName()).isEqualTo(webType.getName());
        assertThat(actualType.getDescription()).isEqualTo(webType.getDescription());
        assertThat(actualType.getExtension()).isEqualTo(webType.getExtension());

    }

    @Test
    public void testListAllWithBeanConfiguration() throws Exception {
        documents = engine.listAll();
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(4);
    }

}

