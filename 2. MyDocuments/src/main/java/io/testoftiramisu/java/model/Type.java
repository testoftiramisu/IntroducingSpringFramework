package io.testoftiramisu.java.model;

public class Type {
    private String typeId;
    private String name;
    private String description;
    private String extension;

    public Type() {
    }

    public Type(String name, String extension) {
        this.name = name;
        this.extension = extension;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extencion) {
        this.extension = extencion;
    }

    public String toString() {
        return "Type(" + "name: " +
                name +
                " id: " +
                typeId +
                ", description: " +
                description +
                ", extension: " +
                extension +
                ")";
    }
}
