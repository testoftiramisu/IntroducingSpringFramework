package io.testoftiramisu.spring.test;

import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.java.service.SearchEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-jms-context.xml")
public class MyDocumentsJMSTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsJMSTest.class);

    private static final int MAX_ALL_DOCS = 5;
    private static final int MAX_WEB_DOCS = 2;

    @Autowired
    private SearchEngine engine;


    @Test
    public void testSpringJMS() throws InterruptedException {
        log.debug("Testing Spring JMS Listener/Insert...");
        assertThat(engine).isNotNull();

        // Waiting at least 5 seconds, so the message is consumed
        Thread.sleep(5000);

        // After JMX message and Insert, must be 5 documents
        assertThat(engine.listAll()).hasSize(MAX_ALL_DOCS);

        Type type = new Type("WEB", ".url");
        assertThat(engine.findByType(type)).hasSize(MAX_WEB_DOCS);
    }
}
