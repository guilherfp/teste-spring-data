package br.com.devsorce.teste.springdata;

/**
 * @author Guilherme Pacheco
 */
public class Client {

  private long id;
  private String firstName;
  private String lastName;

  public Client(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public long getId() {
    return id;
  }

  void setId(long id) {
    this.id = id;
  }

  public String getFirtName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public String toString() {
    return String.format("Client = id: %s, firstName: %s, lastName: %s", id, firstName, lastName);
  }

}
