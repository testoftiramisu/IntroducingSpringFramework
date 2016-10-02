package io.testoftiramisu.spring;

import io.testoftiramisu.spring.service.Login;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

public class MyDocumentsWithLoginTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithLoginTest.class);
    private static final String EMAIL = "test@mydocuments.com";
    private static final String PASS = "test123";
    private static final String SUCCESS = "This user is authorized";
    private static final String FAILURE = "WARNING!!! Thai user is not authorized!";
    private ClassPathXmlApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-login-context.xml");

    }

    @Test
    public void testLogin() {
        log.debug("Login test.");
        Login login = context.getBean(Login.class);
        assertThat(login).isNotNull();
        if (login.isAuthorized(EMAIL, PASS)) {
            out.println(SUCCESS);
        } else {
            out.println(FAILURE);
        }
    }
}
