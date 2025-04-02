CREATE SCHEMA IF NOT EXISTS caioribeiro;

USE caioribeiro;

CREATE TABLE IF NOT EXISTS cliente (
    id_cliente INT AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    nascimento DATETIME,
    id_tipo_cliente INT,
    id_sexo INT,
    PRIMARY KEY (id_cliente)
);

CREATE TABLE IF NOT EXISTS tipo_cliente (
    id_tipo_cliente INT AUTO_INCREMENT,
    descricao VARCHAR(45),
    PRIMARY KEY (id_tipo_cliente)
);

CREATE TABLE IF NOT EXISTS endereco (
    id_endereco INT AUTO_INCREMENT,
    logradouro VARCHAR(45) NOT NULL,
    numero VARCHAR(45),
    complemento VARCHAR(45),
    bairro VARCHAR(45),
    cidade VARCHAR(45),
    cep VARCHAR(45),
    uf VARCHAR(45),
    id_cliente INT,
    PRIMARY KEY (id_endereco)
);

CREATE TABLE IF NOT EXISTS telefone (
    numero VARCHAR(40),
    id_cliente INT,
    PRIMARY KEY (numero, id_cliente)
);

CREATE TABLE IF NOT EXISTS sexo (
    id_sexo INT AUTO_INCREMENT,
    descricao VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_sexo)
);

CREATE TABLE IF NOT EXISTS pet (
    id_pet INT AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    nascimento DATETIME,
    id_cliente INT,
    id_sexo INT,
    id_raca INT,
    PRIMARY KEY (id_pet)
);

CREATE TABLE IF NOT EXISTS raca (
    id_raca INT AUTO_INCREMENT,
    nome VARCHAR(45) NOT NULL,
    descricao VARCHAR(45) NOT NULL,
    id_porte_pet INT,
    PRIMARY KEY (id_raca)
);

CREATE TABLE IF NOT EXISTS porte_pet (
    id_porte_pet INT AUTO_INCREMENT,
    descricao VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_porte_pet)
);

ALTER TABLE cliente
ADD CONSTRAINT fk_cliente_tipo_cliente
FOREIGN KEY (id_tipo_cliente) REFERENCES tipo_cliente(id_tipo_cliente);

ALTER TABLE cliente 
ADD CONSTRAINT fk_cliente_sexo
FOREIGN KEY (id_sexo) REFERENCES sexo(id_sexo);

ALTER TABLE endereco
ADD CONSTRAINT fk_endereco_cliente
FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
ON DELETE CASCADE;

ALTER TABLE pet
ADD CONSTRAINT fk_pet_cliente
FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
ON DELETE CASCADE;

ALTER TABLE pet
ADD CONSTRAINT fk_pet_sexo
FOREIGN KEY (id_sexo) REFERENCES sexo(id_sexo);

ALTER TABLE pet
ADD CONSTRAINT fk_pet_raca
FOREIGN KEY (id_raca) REFERENCES raca(id_raca);

ALTER TABLE raca
ADD CONSTRAINT fk_raca_porte_pet
FOREIGN KEY (id_porte_pet) REFERENCES porte_pet(id_porte_pet);

ALTER TABLE telefone
ADD CONSTRAINT fk_telefone_cliente
FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
ON DELETE CASCADE;