package br.com.devsorce.teste.springdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 * @author Guilherme Pacheco
 */
public class ClientDao {

  private JdbcTemplate jdbcTemplate;
  private SimpleJdbcInsert insertClient;

  public ClientDao(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
    insertClient = new SimpleJdbcInsert(dataSource)
        .withTableName("client")
        .usingGeneratedKeyColumns("id");
  }

  public void add(Client client) {
    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("fist_name", client.getFirtName())
        .addValue("last_name", client.getLastName());
    Number newId = insertClient.executeAndReturnKey(parameters);
    client.setId(newId.longValue());
  }

  public List<Client> findAll() {
    String sql = "select * from client";
    return jdbcTemplate.query(sql, new ClientMapper());
  }

  public Client findById(long id) {
    String sql = "select * from client where id = ?";
    return jdbcTemplate.queryForObject(sql, new ClientMapper(), id);
  }

  private static class ClientMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
      String fistName = rs.getString("fist_name");
      String lastName = rs.getString("last_name");
      Client client = new Client(fistName, lastName);
      client.setId(rs.getLong("id"));
      return client;
    }
  }
}
