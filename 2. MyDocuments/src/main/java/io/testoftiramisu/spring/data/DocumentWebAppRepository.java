package io.testoftiramisu.spring.data;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.spring.jdbc.DocumentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository("documentDAO")
public class DocumentWebAppRepository implements DocumentDAO {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private String query;

    @Override
    public List<Document> getAll() {
        return new JdbcTemplate(this.dataSource).query(query, new DocumentRowMapper());
    }
}
