package io.testoftiramisu.spring.jdbc;

import io.testoftiramisu.java.model.Document;
import io.testoftiramisu.spring.data.DocumentDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class DocumentJdbcTemplateRepository implements DocumentDAO {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    private String query;

    @Override
    public List<Document> getAll() {
        return jdbcTemplate.query(query, new DocumentRowMapper());
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public void save(Document document) {

    }
}
