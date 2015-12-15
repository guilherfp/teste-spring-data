CREATE TABLE client (
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  fist_name VARCHAR(100),
  last_name VARCHAR(100)
);

create table perfil (
  id integer auto_increment primary key,
  descricao varchar(100),
  id_perfil_pai integer
);

create table perfil_permissoes (
  id_perfil integer,
  permissao varchar(80)
);

insert into perfil values (1, 'Perfil 1', null);
insert into perfil values (2, 'Perfil 2', 1);
insert into perfil values (3, 'Perfil 3', 2);

insert into perfil_permissoes values (1, 'A');
insert into perfil_permissoes values (1, 'B');
insert into perfil_permissoes values (1, 'H');
insert into perfil_permissoes values (2, 'C');
insert into perfil_permissoes values (2, 'D');
insert into perfil_permissoes values (3, 'E');
insert into perfil_permissoes values (3, 'F');