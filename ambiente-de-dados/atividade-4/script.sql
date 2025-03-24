CREATE SCHEMA IF NOT EXISTS atividade04;

USE atividade04;

CREATE TABLE IF NOT EXISTS pessoa (
id_pessoa INT AUTO_INCREMENT,
nome VARCHAR(45) NOT NULL,
logradouro VARCHAR(45) NOT NULL,
complemento VARCHAR(90),
cep VARCHAR(8) NOT NULL,
numero VARCHAR(10) NOT NULL,
bairro VARCHAR(10) NOT NULL,
uf VARCHAR(2) NOT NULL,
PRIMARY KEY (id_pessoa)
);

CREATE TABLE IF NOT EXISTS telefone (
id_telefone INT AUTO_INCREMENT,
numero VARCHAR(45) NOT NULL,
PRIMARY KEY (id_telefone)
);

CREATE TABLE IF NOT EXISTS classificacao (
id_classificacao INT AUTO_INCREMENT,
tipo VARCHAR(20) NOT NULL,
valor_maximo DECIMAL(10,2) NOT NULL,
PRIMARY KEY (id_classificacao)
);

CREATE TABLE IF NOT EXISTS presente (
id_presente INT AUTO_INCREMENT,
nome VARCHAR(45) NOT NULL,
preco DECIMAL(10,2) NOT NULL,
PRIMARY KEY (id_presente)
);

CREATE TABLE IF NOT EXISTS tipo_presente (
id_tipo_presente INT AUTO_INCREMENT,
nome VARCHAR(45) NOT NULL,
PRIMARY KEY (id_tipo_presente)
);

ALTER TABLE pessoa
ADD COLUMN id_classificacao INT,
ADD CONSTRAINT fk_id_classificacao
FOREIGN KEY (id_classificacao) REFERENCES classificacao(id_classificacao);

ALTER TABLE telefone
ADD COLUMN id_pessoa INT,
ADD CONSTRAINT fk_id_pessoa
FOREIGN KEY (id_pessoa) REFERENCES pessoa(id_pessoa);

ALTER TABLE presente
ADD COLUMN id_tipo_presente INT,
ADD CONSTRAINT fk_id_tipo_presente
FOREIGN KEY (id_tipo_presente) REFERENCES tipo_presente(id_tipo_presente);

CREATE TABLE IF NOT EXISTS pessoa_presente (
id_pessoa INT,
id_presente INT,
data_presente DATE NOT NULL,
PRIMARY KEY (id_pessoa, id_presente)
);

ALTER TABLE pessoa_presente
ADD CONSTRAINT fk_pp_pessoa FOREIGN KEY (id_pessoa) REFERENCES pessoa(id_pessoa),
ADD CONSTRAINT fk_pp_presente FOREIGN KEY (id_presente) REFERENCES presente(id_presente),
ADD COLUMN id_tipo_presente INT,
ADD CONSTRAINT fk_pp_tipo_presente FOREIGN KEY (id_tipo_presente) REFERENCES tipo_presente(id_tipo_presente),
ADD CONSTRAINT uk_pp_pessoa_tipo_presente UNIQUE (id_pessoa, id_tipo_presente);




