package br.com.devsorce.teste.springdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author Guilherme Pacheco
 */
public class PerfilMapper implements RowMapper<Perfil> {

  private PerfilRepository perfilRepository;

  public PerfilMapper(PerfilRepository perfilRepository) {
    this.perfilRepository = perfilRepository;
  }

  @Override
  public Perfil mapRow(ResultSet rs, int rowNum) throws SQLException {
    Perfil perfil = new Perfil();
    long id = rs.getLong("id");
    perfil.setId(id);
    perfil.setDescricao(rs.getString("descricao"));
    Long idPai = rs.getLong("id_perfil_pai");
    if (idPai != 0) {
      perfil.setPai(perfilRepository.comId(idPai.intValue()));
    }
    perfil.setPermissoes(getPermissoes(id));
    return perfil;
  }

  private Set<Permissao> getPermissoes(long id) {
    List<Permissao> permissoes = perfilRepository.permissoes(id);
    return new HashSet<>(permissoes);
  }

}
