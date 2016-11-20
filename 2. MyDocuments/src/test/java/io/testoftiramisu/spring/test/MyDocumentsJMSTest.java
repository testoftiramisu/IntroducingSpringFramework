package io.testoftiramisu.spring.test;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.java.service.SearchEngine;
import io.testoftiramisu.spring.amqp.RabbitMQProducer;
import io.testoftiramisu.spring.jms.JMSProducer;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-jms-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyDocumentsJMSTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsJMSTest.class);

    private static final int MAX_ALL_DOCS = 5;
    private static final int MAX_WEB_DOCS = 2;
    private static final String DOCUMENT_ID = "df569fa4-a513-4252-9810-818cade184ca";

    @Autowired
    JMSProducer jmsProducer;
    @Autowired
    private SearchEngine engine;

    @Test
    public void testSpringJMS1Producer() {
        log.debug("Testing Spring JMS producer...");
        jmsProducer.send();
    }

    @Test
    public void testSpringJMS2Consumer() throws InterruptedException {
        log.debug("Testing Spring JMS Listener/Insert...");
        assertThat(engine).isNotNull();

        // Waiting at least 5 seconds, so the message is consumed
        Thread.sleep(5000);

        // After JMX message and Insert, must be 5 documents
        assertThat(engine.listAll()).hasSize(MAX_ALL_DOCS);

        Type type = new Type("WEB", ".url");
        assertThat(engine.findByType(type)).hasSize(MAX_WEB_DOCS);
    }

    @Autowired
    RabbitMQProducer rabbitMQProducer;

    @Test
    public void testSpringRabbitMQ() {
        log.debug("Testing RabbitMQ producer...");
        assertThat(rabbitMQProducer).isNotNull();

        Document document = engine.findById(DOCUMENT_ID);
        assertThat(document).isNotNull();
        rabbitMQProducer.send(document);
    }

}
