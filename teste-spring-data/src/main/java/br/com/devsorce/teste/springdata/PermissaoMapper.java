package br.com.devsorce.teste.springdata;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author Guilherme Pacheco
 */
public class PermissaoMapper implements RowMapper<Permissao> {

  @Override
  public Permissao mapRow(ResultSet rs, int rowNum) throws SQLException {
    return Permissao.valueOf(rs.getString("permissao"));
  }

}
