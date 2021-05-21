# persons-api

Uma API em Java e Spring Boot com um banco de dados Postgresql para gerenciamento de pessoas com seus endereços (todos com paginação).

## Endpoints da API

URL base para busca de pessoas (retorna a primeira página dos resultados):
>[https://manager-persons-api.herokuapp.com/api/v1/persons](https://manager-persons-api.herokuapp.com/api/v1/persons)

Busca de pessoas por ID:
>[https://manager-persons-api.herokuapp.com/api/v1/persons/1](https://manager-persons-api.herokuapp.com/api/v1/persons/1)

URL base para busca de endereços cadastrados (retorna a primeira página dos resultados):
>[https://manager-persons-api.herokuapp.com/api/v1/addresses](https://manager-persons-api.herokuapp.com/api/v1/addresses)

Busca de endereços por ID:
>[https://manager-persons-api.herokuapp.com/api/v1/addresses/1](https://manager-persons-api.herokuapp.com/api/v1/addresses/1)

## Manipulação de dados

### Adicionando pessoas

Faça um POST para o seguinte endpoint:
>[https://manager-persons-api.herokuapp.com/api/v1/persons](https://manager-persons-api.herokuapp.com/api/v1/persons)

Modelo de entrada:
```
{
    "name": "Carlos",
    "birthDate": "2000-11-11",
    "weight": 90.0,
    "height": 1.85,
    "address": {
        "street": "Fazenda Estreito",
        "district": "Zona Rural",
        "city": "Baia Formosa",
        "houseNumber": 17,
        "cep": 59194000
    }
}
```

### Modificando registros

Faça um PUT para o seguinte endpoint:
>[https://manager-persons-api.herokuapp.com/api/v1/persons](https://manager-persons-api.herokuapp.com/api/v1/persons)

Modelo de entrada:
```
{
    "id": 11,
    "name": "Carlos Antonio",
    "birthDate": "1980-11-27",
    "weight": 60.5,
    "height": 1.82,
    "address": {
        "idAddress": 11,
        "street": "Fazenda Pituba",
        "district": "Zona Rural",
        "city": "Baia Formosa",
        "houseNumber": 10,
        "cep": 59194000
    }
}
```

*No caso de uma atualização é necessário passar o ID do usuário que vai ser modificado e o respectivo o ID do endereço. Também é necessário passar os dados que não serão alterados.

### Apagando registros

Faça um DELETE para o endpoint:
>https://manager-persons-api.herokuapp.com/api/v1/persons/{ID}

*No lugar de {ID} insira o ID do usuário que deseja apagar.

## Extras

### Banco de dados Postgresql criado via docker

Estrutura do banco:

```
--
-- Estrutura da tabela "person"
--

DROP TABLE IF EXISTS "person" CASCADE;

CREATE TABLE person (
  id bigserial primary key,
  name varchar(80),
  birth_date date,
  weight real,
  height real,
  address integer
);

--
-- Inserindo dados na tabela "person"
--

INSERT INTO "person" (id, name, birth_date, weight, height, address) VALUES
(1, 'João', '1985-08-06', 67.6, 1.75, 1),
(2, 'Maria', '1964-12-25', 55.9, 1.66, 2),
(3, 'Paula', '1988-09-13', 68.9, 1.65, 3),
(4, 'Rosa', '1997-12-27', 57.6, 1.85, 4),
(5, 'Talita', '1974-10-18', 55.1, 1.39, 5),
(6, 'Joana', '2000-11-27', 52.9, 1.88, 6),
(7, 'Carla', '1998-03-06', 65.4, 1.60, 7),
(8, 'Pedro', '1999-04-08', 70.5, 1.62, 8),
(9, 'Lucas', '1996-12-01', 80.9, 1.73, 9),
(10, 'Marciel', '1977-12-30', 77.7, 1.40, 10);

ALTER SEQUENCE person_id_seq
  RESTART 11;
```

```
--
-- Estrutura da tabela "address"
--

DROP TABLE IF EXISTS "address" CASCADE;

CREATE TABLE address (
  id_address bigserial primary key,
  street varchar(40),
  district varchar(40),
  city varchar(40),
  house_number integer,
  cep bigint
);

--
-- Inserindo dados na tabela "address"
--

INSERT INTO "address" (id_address, street, district, city, house_number, cep) VALUES
(1, 'Avenida Nilo Peçanha', 'Praia do Meio', 'Natal', 59, 59010056),
(2, 'Rua Monte Alegre', 'Praia do Meio', 'Natal', 28, 59010100),
(3, 'Travessa Doutor Manoel Dantas', 'Petrópolis', 'Natal', 17, 59012275),
(4, 'Rua Frei Miguelinho', 'Ribeira', 'Natal', 115, 59012180),
(5, 'Rua Cláudio Machado', 'Petrópolis', 'Natal', 265, 59012310),
(6, '4ª Travessa João XXIII', 'Mãe Luiza', 'Natal', 854, 59014008),
(7, 'Rua Desembargador Lemos Filho', 'Rocas', 'Natal', 345, 59010260),
(8, 'Travessa Jordanês', 'Rocas', 'Natal', 941, 59010385),
(9, 'Travessa São Jorge",', 'Rocas', 'Natal', 22, 59010665),
(10, 'Rua São José', 'Lagoa Nova', 'Natal', 2000, 59063150);

ALTER SEQUENCE address_id_address_seq
  RESTART 11;
```

### JDK Version
Open JDK 8
