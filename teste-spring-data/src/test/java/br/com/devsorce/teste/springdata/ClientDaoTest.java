package br.com.devsorce.teste.springdata;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ClientDaoTest {

  private ClientDao clientDao;

  @Before
  public void setUp() throws Exception {
    clientDao = new ClientDao(DatasourceBuilder.getDataSource());
  }

  @Test
  public void testAdd() throws Exception {
    assertEquals(0, clientDao.findAll().size());
    clientDao.add(new Client("a", "b"));
    assertEquals(1, clientDao.findAll().size());
  }

  @Test
  public void testFindAll() throws Exception {
    populate();
    List<Client> all = clientDao.findAll();
    assertEquals(5, all.size());
    all.forEach(System.out::println);
  }

  @Test
  public void testFindById() throws Exception {
    populate();
    Client client = clientDao.findById(1);
    assertNotNull(client);
  }

  private void populate() {
    for (int i = 1; i < 5; i++) {
      clientDao.add(new Client("FistName " + i, "LastName " + i));
    }
  }

}
