package io.testoftiramisu.spring.data;

import io.testoftiramisu.java.model.Type;

interface TypeDataDAO {
    public Type[] getAll();

    public Type findById(String id);
}
