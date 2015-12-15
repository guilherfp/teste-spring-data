package br.com.devsorce.teste.springdata;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Guilherme Pacheco
 */
public class PerfilRepository {

  private JdbcTemplate jdbcTemplate;
  private PerfilMapper perfilMapper;

  public PerfilRepository(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
    perfilMapper = new PerfilMapper(this);
  }

  public Perfil comId(int id) {
    String sql = "select * from perfil where id = ?";
    Object[] args = new Object[] { id };
    return jdbcTemplate.queryForObject(sql, args, perfilMapper);
  }

  public List<Permissao> permissoes(long idPeril) {
    String sql = "select * from perfil_permissoes where id_perfil = ?";
    Object[] args = new Object[] { idPeril };
    return jdbcTemplate.query(sql, args, new PermissaoMapper());
  }

}
