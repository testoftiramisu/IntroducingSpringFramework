package io.testoftiramisu.spring.jdbc;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DocumentRowMapper implements RowMapper<Document> {
    @Override
    public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
        Document document = new Document();
        document.setDocumentId(rs.getString("documentId"));
        document.setName(rs.getString("name"));
        document.setLocation(rs.getString("location"));
        document.setCreated(rs.getDate("created"));
        document.setModified(rs.getDate("modified"));
        document.setDescription(rs.getString("doc_desc"));
        Type type = new Type();
        type.setTypeId(rs.getString("typeId"));
        type.setName(rs.getString("type_name"));
        type.setDescription(rs.getString("type_desc"));
        type.setExtension(rs.getString("extension"));
        document.setType(type);
        return document;

    }
}
