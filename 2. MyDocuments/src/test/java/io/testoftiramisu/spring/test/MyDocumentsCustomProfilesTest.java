package io.testoftiramisu.spring.test;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.java.service.SearchEngine;
import io.testoftiramisu.spring.test.profile.CustomProfile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-custom-profiles-context.xml")
@ProfileValueSourceConfiguration(CustomProfile.class)
public class MyDocumentsCustomProfilesTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsCustomProfilesTest.class);

    @Autowired
    private SearchEngine engine;
    @Autowired
    private Type webType;

    @IfProfileValue(name = "environment", values = "dev")
    @Test
    public void findByWithSpringTestAndCustomProfile() {
        log.debug("Test findByType using profile from CustomProfile.class: ");

        List<Document> documents = engine.findByType(webType);
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(1);

        assertThat(documents.get(0).getType().getName()).isEqualTo(webType.getName());
        assertThat(documents.get(0).getType().getDescription()).isEqualTo(webType.getDescription());
        assertThat(documents.get(0).getType().getExtension()).isEqualTo(webType.getExtension());
    }

    @IfProfileValue(name = "environment", values = "dev")
    @Test
    public void listAllWithSpringTestAndCustomProfile() {
        log.debug("Test listAll using profile from CustomProfile.class: ");

        List<Document> documents = engine.listAll();
        assertThat(documents).isNotNull();
        assertThat(documents).hasSize(4);
    }

    @IfProfileValue(name = "os.name", values = "Unix")
    @Test
    public void testUsingSpringWithCustomProfile() {
        try {
            log.debug("Using Spring Test fixtures on Unix: ");
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
    }
}
