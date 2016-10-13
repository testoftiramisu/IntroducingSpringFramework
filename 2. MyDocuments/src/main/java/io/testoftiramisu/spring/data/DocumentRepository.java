package io.testoftiramisu.spring.data;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DocumentRepository implements DocumentDAO {
    private DataSource dataSource;
    private List<Document> documents = null;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Document> getAll() {
        List<Document> result = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Document document = null;
        Type type = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from documents");
            while (resultSet.next()) {
                document = new Document();
                document.setDocumentId(resultSet.getString("documentId"));
                document.setName(resultSet.getString("name"));
                document.setLocation(resultSet.getString("location"));
                document.setCreated(resultSet.getDate("created"));
                document.setModified(resultSet.getDate("modified"));
                document.setDescription(resultSet.getString("description"));
                result.add(document);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (null != connection) {
                try {
                    connection.close();
                } catch (SQLException ex) {

                }
            }
        }
        return result;
    }
}
