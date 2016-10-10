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
@ContextConfiguration("classpath:META-INF/spring/mydocuments-aop-context.xml")
public class MyDocumentsAOPTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsAOPTest.class);

    @Autowired
    private SearchEngine engineProxy;

    @Autowired
    private Type webType;

    @Test
    public void findByTypeUsingSpringAOP() {
        log.debug("Test findByType using Spring AOP: ");

        List<Document> documents = engineProxy.findByType(webType);
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(1);

        assertThat(documents.get(0).getType().getName()).isEqualTo(webType.getName());
        assertThat(documents.get(0).getType().getDescription()).isEqualTo(webType.getDescription());
        assertThat(documents.get(0).getType().getExtension()).isEqualTo(webType.getExtension());
    }

    @Test
    public void listAllUsingSpringAOP() throws Exception {
        log.debug("Test listAll using Spring AOP: ");

        List<Document> documents = engineProxy.listAll();
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(4);
    }

    @Test
    public void findByLocationUsingSpringAOP() throws Exception {
        log.debug("Test findByLocation using Spring AOP: ");

        try {
            engineProxy.findByLocation("/some/path");
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}
