package io.testoftiramisu.spring;

import io.testoftiramisu.spring.views.Menu;
import io.testoftiramisu.spring.views.ResourceLoaderMenu;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class MyDocumentsWithResourceLoaderInjectionTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithResourceLoaderInjectionTest.class);
    private ClassPathXmlApplicationContext context;

    @Test
    public void testMenu() {
        log.debug("Calling the  menu as Resource Injection");
        ResourceLoaderMenu menu = context.getBean(ResourceLoaderMenu.class);
        assertThat(menu).isNotNull();
        menu.printMenu("classpath:META-INF/data/menu.txt");
    }

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-resourceloader-injection-context.xml");
    }
}

