package io.testoftiramisu.spring;

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
    private ClassPathXmlApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-context.xml");
    }

    @Test
    public void testWithSpringFindByType() {
        engine = context.getBean(SearchEngine.class);
        webType = context.getBean("webType", Type.class);

        List<Document> documents = engine.findByType(webType);
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(1);

        Type actualType = documents.get(0).getType();
        assertThat(actualType.getName()).isEqualTo(webType.getName());
        assertThat(actualType.getDescription()).isEqualTo(webType.getDescription());
        assertThat(actualType.getExtension()).isEqualTo(webType.getExtension());

        // Because of using scope=" prototype" in mydocuments-context.xml
        // Spring container will create a new instance of these SearchEngineService and DocumentRepository
        // once the getBean method from the application context is called
        engine = context.getBean(SearchEngine.class);

    }

    @Test
    public void listAllShouldReturnFourDocumentTypes() throws Exception {
        engine = context.getBean(SearchEngine.class);

        List<Document> documents = engine.listAll();
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(4);
    }

}
