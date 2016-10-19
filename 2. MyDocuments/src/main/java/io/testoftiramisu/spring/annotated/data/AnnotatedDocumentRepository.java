package io.testoftiramisu.spring.annotated.data;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.java.model.Type;
import io.testoftiramisu.spring.data.DocumentDAO;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository("documentDAO")
public class AnnotatedDocumentRepository implements DocumentDAO {
    private static final String queryAll = " select d.documentId, d.name, d.location, d.description as doc_desc," +
            "d.typeId, d.created, d.modified, " +
            "t.name as type_name, t.description as type_desc," +
            "t.extension from documents d join types t on d.typeId = t.typeId";

    //@Autowired
    private DataSource dataSource;

    @Override
    public List<Document> getAll() {
        List<Document> result = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Document document = null;
        Type type = null;

        if (null != dataSource) {
            try {
                connection = dataSource.getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery(queryAll);
                while (resultSet.next()) {
                    document = new Document();
                    document.setDocumentId(resultSet.getString("documentId"));
                    document.setName(resultSet.getString("name"));
                    document.setLocation(resultSet.getString("location"));
                    document.setCreated(resultSet.getDate("created"));
                    document.setModified(resultSet.getDate("modified"));
                    document.setDescription("dec_desc");
                    type = new Type();
                    type.setTypeId(resultSet.getString("typeId"));
                    type.setName(resultSet.getString("type_name"));
                    type.setDescription(resultSet.getString("type_desc"));
                    type.setExtension(resultSet.getString("extension"));
                    document.setType(type);

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
        } else {
            return Arrays.asList(storage());
        }

    }

    private Document[] storage() {
        List<Document> result = new ArrayList<>();

        Type type = new Type();
        type.setName("PDF");
        type.setDescription("Portable Document format");
        type.setExtension(".pdf");

        Document document = new Document();
        document.setName("Book Template");
        document.setType(type);
        document.setLocation("/Users/Tiramisu/Documents/tmp/Book Template.pdf");
        result.add(document);

        document = new Document();
        document.setName("Sample contract");
        document.setType(type);
        document.setLocation("/Users/Tiramisu/Documents/tmp/Sample Contract.pdf");
        result.add(document);

        type = new Type();
        type.setName("NOTE");
        type.setDescription("Text Notes");
        type.setExtension(".txt");

        document = new Document();
        document.setName("Clustering with RabbitMQ");
        document.setType(type);
        document.setLocation("/Users/Tiramisu/Documents/tmp/Clustering with RabbitMQ.txt");
        result.add(document);

        type = new Type();
        type.setName("WEB");
        type.setDescription("Web Link");
        type.setExtension(".url");

        document = new Document();
        document.setName("Pro Spring Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");
        result.add(document);

        return result.toArray(new Document[result.size()]);
    }


}
