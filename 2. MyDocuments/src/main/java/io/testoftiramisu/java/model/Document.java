package io.testoftiramisu.java.model;

import java.util.Date;

public class Document {
    private String documentId;
    private String name;
    private Type type;
    private String location;
    private Date created;
    private Date modified;
    private String Description;

    public String getName() {
        return name;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String toString() {
        return "Documents(" + "name: " +
                name +
                " id: " +
                documentId +
                ", type: " +
                type +
                ", location: " +
                location + ")";
    }
}
