package br.com.devsorce.teste.springdata;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author Guilherme Pacheco
 */
public class DatasourceBuilder {

  private static DataSource dataSource;

  public static synchronized DataSource getDataSource() {
    if (dataSource == null) {
      dataSource = buildDatasource();
    }
    return dataSource;
  }

  private static DataSource buildDatasource() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .addScript("schema.sql");
    return builder.build();
  }

}
