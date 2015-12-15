package br.com.devsorce.teste.springdata;

import org.junit.Before;
import org.junit.Test;

public class PerfilRepositoryTest {

  private PerfilRepository perfilRepository;

  @Before
  public void setUp() throws Exception {
    perfilRepository = new PerfilRepository(DatasourceBuilder.getDataSource());
  }

  @Test
  public void testComId() throws Exception {
    Perfil perfil = perfilRepository.comId(3);
    System.out.println(perfil.getPermissoes());
    System.out.println(perfil);
  }

}
