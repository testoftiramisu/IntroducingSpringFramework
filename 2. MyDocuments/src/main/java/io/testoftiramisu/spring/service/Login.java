package io.testoftiramisu.spring.service;

public interface Login {
    boolean isAuthorized(String email, String pass);
}
