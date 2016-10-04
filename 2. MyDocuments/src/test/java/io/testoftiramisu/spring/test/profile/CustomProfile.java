package io.testoftiramisu.spring.test.profile;

import org.springframework.test.annotation.ProfileValueSource;

public class CustomProfile implements ProfileValueSource {

    @Override
    public String get(String key) {
        switch (key) {
            case "dev":
                return "Development";
            case "qa":
                return "QA";
            case "environment":
                return "dev";
        }
        return null;
    }
}
