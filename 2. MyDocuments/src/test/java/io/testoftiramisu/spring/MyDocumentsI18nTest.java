package io.testoftiramisu.spring;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static java.lang.System.out;

import java.io.PrintStream;
import java.util.Locale;

public class MyDocumentsI18nTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsI18nTest.class);
    private ClassPathXmlApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-i18n-context.xml");
    }

    @Test
    public void testMenu()  throws java.io.UnsupportedEncodingException{
        log.debug("About to translate....");

        String english = context.getMessage("main.title", null, Locale.ENGLISH);
        String spanish = context.getMessage("main.title", null, new Locale("es"));
        String russian = context.getMessage("main.title", null, new Locale("ru"));
        out.println("English: " + english);
        out.println("Spanish: " + spanish);

        // Same output, but with PrintStream:
        PrintStream ps = new PrintStream(System.out, true, "UTF-8");
        ps.println("Russian: " + russian);
    }

}
