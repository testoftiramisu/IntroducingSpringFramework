package io.testoftiramisu.spring.test;

import io.testoftiramisu.spring.views.Menu;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class MyDocumentsWithResourceInjectionTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithResourceInjectionTest.class);
    private ClassPathXmlApplicationContext context;

    @Test
    public void testMenu() {
        log.debug("Calling the  menu as Resource Injection");
        Menu menu = context.getBean(Menu.class);
        assertThat(menu).isNotNull();
        menu.printMenu();
    }

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-resource-injection-context.xml");
    }
}

