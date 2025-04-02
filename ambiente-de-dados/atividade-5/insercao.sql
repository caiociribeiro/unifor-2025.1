START TRANSACTION;

INSERT INTO tipo_cliente (descricao) VALUES ('vip');
INSERT INTO tipo_cliente (descricao) VALUES ('comum');

INSERT INTO sexo (descricao) VALUES ('masculino');
INSERT INTO sexo (descricao) VALUES ('feminino');

INSERT INTO porte_pet (descricao) VALUES ('pequeno');
INSERT INTO porte_pet (descricao) VALUES ('medio');
INSERT INTO porte_pet (descricao) VALUES ('grande');

INSERT INTO raca (nome, descricao, id_porte_pet)
VALUES ('cocker spaniel', 'cachorro', 2);
INSERT INTO raca (nome, descricao, id_porte_pet)
VALUES ('pibull', 'cachorro', 2);
INSERT INTO raca (nome, descricao, id_porte_pet)
VALUES ('chihuahua', 'cachorro', 1);
INSERT INTO raca (nome, descricao, id_porte_pet)
VALUES ('akita', 'cachorro', 3);

INSERT INTO cliente (nome, nascimento, id_tipo_cliente, id_sexo)
VALUES ('Caio Ribeiro', '1996-03-02 08:32:00', 1, 1);
INSERT INTO cliente (nome, nascimento, id_tipo_cliente, id_sexo)
VALUES ('Priscila', '1950-02-27 10:30:00', 2, 2);
INSERT INTO cliente (nome, nascimento, id_tipo_cliente, id_sexo)
VALUES ('Tobias Cruz', '1995-11-09 00:00:00', 2, 1);
INSERT INTO cliente (nome, nascimento, id_tipo_cliente, id_sexo)
VALUES ('Fernanda', '1999-12-05 23:00:00', 1, 2);

INSERT INTO telefone (numero, id_cliente) VALUES ('+558599999999', 1);
INSERT INTO telefone (numero, id_cliente) VALUES ('+558599999998', 1);
INSERT INTO telefone (numero, id_cliente) VALUES ('+558599999997', 2);
INSERT INTO telefone (numero, id_cliente) VALUES ('+558599999996', 3);
INSERT INTO telefone (numero, id_cliente) VALUES ('+558599999995', 4);

INSERT INTO pet (nome, nascimento, id_cliente, id_sexo, id_raca)
VALUES ('Aslan', '2017-08-17 00:00:00', 1, 1, 1);
INSERT INTO pet (nome, nascimento, id_cliente, id_sexo, id_raca)
VALUES ('Bruce', '2019-05-10 00:00:00', 2, 1, 3);
INSERT INTO pet (nome, nascimento, id_cliente, id_sexo, id_raca)
VALUES ('Diana', '2024-07-08 00:00:00', 3, 2, 2);
INSERT INTO pet (nome, nascimento, id_cliente, id_sexo, id_raca)
VALUES ('Jurubelsona', '2020-05-10 00:00:00', 4, 2, 4);

COMMIT;
