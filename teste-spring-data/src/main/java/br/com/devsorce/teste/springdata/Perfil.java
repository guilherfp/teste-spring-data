package br.com.devsorce.teste.springdata;

import java.util.Set;

/**
 * @author Guilherme Pacheco
 */
public class Perfil {

  private long id;
  private Perfil pai;
  private String descricao;
  private Set<Permissao> permissoes;

  public Perfil getPai() {
    return pai;
  }

  public void setPai(Perfil pai) {
    this.pai = pai;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Set<Permissao> getPermissoes() {
    if (pai != null) {
      permissoes.addAll(pai.getPermissoes());
    }
    return permissoes;
  }

  public void setPermissoes(Set<Permissao> permissoes) {
    this.permissoes = permissoes;
  }

  @Override
  public String toString() {
    return String.format("Perfil [id: %s, pai: %s, descricao: %s, permissoes: %s]", id, pai,
      descricao, permissoes);
  }

}
