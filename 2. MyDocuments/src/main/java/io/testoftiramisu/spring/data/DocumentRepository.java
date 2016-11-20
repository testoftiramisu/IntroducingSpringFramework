package io.testoftiramisu.spring.data;

import io.testoftiramisu.java.model.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DocumentRepository implements DocumentDAO {
    private static final Logger log = LoggerFactory.getLogger(DocumentRepository.class);
    private List<Document> documents = null;

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Document> getAll() {
        if (log.isDebugEnabled()) {
            log.debug("Start <getAll> Params: ");
        }
        if (log.isDebugEnabled()) {
            log.debug("End <getAll> Result:" + documents.toString());
        }
        return getDocuments();
    }

    @Override
    public void save(Document document) {
        throw new UnsupportedOperationException("Not yet implemented operation.");
    }

    @Override
    public Document findById(String id) {
        throw new UnsupportedOperationException("Not yet implemented operation.");
    }
}
