package io.testoftiramisu.spring.data;

import io.testoftiramisu.model.Document;

public interface DocumentDAO {
    Document[] getAll();
}
