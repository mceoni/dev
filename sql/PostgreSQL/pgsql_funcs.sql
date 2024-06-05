CREATE TYPE tst (	col_a integer,	col_b varchar(20));

select *
from "Filmes";

select *
from "Sessoes";

select *
from "Cinemas";

select *
from "Enderecos";

select *
from users;

select * 
from purchases;

CREATE OR REPLACE FUNCTION contaUsuarios()
RETURNS INTEGER
AS $$
  SELECT COUNT(*)
    FROM users;
$$ LANGUAGE SQL;

SELECT contaUsuarios();

CREATE OR REPLACE FUNCTION consultaUsuario(usuario varchar)
RETURNS users
AS $$
  SELECT id, name
    FROM users
   WHERE name = usuario ;
$$ LANGUAGE SQL;

SELECT consultausuario('Steph');

SELECT * FROM consultausuario('Steph')

CREATE OR REPLACE FUNCTION retorna1()
RETURNS "users"
AS $$
  SELECT 1,'Um';
$$ LANGUAGE SQL;

SELECT retornaUm();

CREATE FUNCTION exibeEndereco(users)
RETURNS TABLE (nome varchar(20), logradouro text, numero integer)
AS $$
  SELECT $1.name, "Logradouro", "Numero"
    FROM "Enderecos"
   WHERE "Enderecos"."Id" = $1.Id
$$ LANGUAGE SQL;

SELECT exibeEndereco(consultausuario('Steph'));

SELECT * FROM exibeEndereco(consultausuario('Steph'));