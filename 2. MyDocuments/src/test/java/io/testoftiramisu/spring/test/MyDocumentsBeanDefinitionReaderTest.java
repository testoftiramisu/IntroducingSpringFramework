package io.testoftiramisu.spring.test;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.java.service.SearchEngine;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyDocumentsBeanDefinitionReaderTest {

    private List<Document> documents;
    private ApplicationContext context;
    private SearchEngine engine;
    private Type webType;

    @Before
    public void setUp() throws Exception {
        context = new GenericGroovyApplicationContext("META-INF/spring/mydocuments.groovy");
        engine = context.getBean(SearchEngine.class);
        webType = context.getBean("webType", Type.class);
    }

    @Test
    public void testFindByTypeWithGroovyBeanConfiguration() {
        documents = engine.findByType(webType);
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(1);

        assertThat(documents.get(0).getType().getName()).isEqualTo(webType.getName());
        assertThat(documents.get(0).getType().getDescription()).isEqualTo(webType.getDescription());
        assertThat(documents.get(0).getType().getExtension()).isEqualTo(webType.getExtension());
    }

    @Test
    public void testListAllWithGroovyBeanConfiguration() throws Exception {
        documents = engine.listAll();
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(4);
    }

}

