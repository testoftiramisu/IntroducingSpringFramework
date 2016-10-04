package io.testoftiramisu.spring.test;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.java.service.SearchEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
public class MyDocumentsTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);

    @Autowired
    private SearchEngine engine;

    @Autowired
    private Type webType;

    @Test
    public void testWithSpringTest() {
        log.debug("Test findByType using Spring Test Fixtures: ");

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
        log.debug("Test listAll using Spring Test Fixtures: ");

        List<Document> documents = engine.listAll();
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(4);
    }



}
