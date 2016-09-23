package io.testoftiramisu.spring.data;

import io.testoftiramisu.model.Document;

public class DocumentRepository implements DocumentDAO {

    private Document document1;
    private Document document2;
    private Document document3;
    private Document document4;

    public Document getDocument1() {
        return document1;
    }

    public void setDocument1(Document document1) {
        this.document1 = document1;
    }

    public Document getDocument2() {
        return document2;
    }

    public void setDocument2(Document document2) {
        this.document2 = document2;
    }

    public Document getDocument3() {
        return document3;
    }

    public void setDocument3(Document document3) {
        this.document3 = document3;
    }

    public Document getDocument4() {
        return document4;
    }

    public void setDocument4(Document document4) {
        this.document4 = document4;
    }

    @Override
    public Document[] getAll() {
        return new Document[]{document1, document2, document3, document4};
    }
}
