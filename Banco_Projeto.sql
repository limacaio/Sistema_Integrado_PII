

/**************USUARIO ***************************************************************/
CREATE TABLE usuario (

codigo integer NOT NULL,
nome  varchar(45) NOT NULL,
email varchar(45) NOT NULL,
senha varchar(45) DEFAULT NULL,
tipo varchar(20) DEFAULT NULL,
situacao integer (1) DEFAULT NULL);

/************************CIDADE*********************************************************/

CREATE TABLE cidade (

codigo integer NOT NULL PRIMARY KEY,
nome varchar(30) NOT NULL,
uf char(2) NOT NULL);

/***********************CLIENTE**********************************************************/

CREATE TABLE cliente (

codigo integer NOT NULL PRIMARY KEY,
nome varchar(30) NOT NULL,
cpf varchar(11) NOT NULL,
telefone varchar (45) NOT NULL,
celular varchar (45) NOT NULL,
email varchar (45) NOT NULL,
senha varchar (45) NOT NULL,
dataNascimento date NOT NULL,
cod_cidade integer NOT NULL,
CONSTRAINT fk_cli_cidade FOREIGN KEY (cod_cidade) REFERENCES cidade(codigo));

/********************************ENDERECO**************************************************/

CREATE TABLE endereco (
codigo int NOT NULL PRIMARY KEY,
descricao varchar (45) NOT NULL,
logradouro varchar (45) NOT NULL,
numero int NOT NULL,
complemento varchar (45) NOT null,
cep varchar (45) not null,
bairro varchar (45) not null,
uf varchar (45) not null,
cod_cliente integer not null,
CONSTRAINT fk_end_cliente FOREIGN KEY (cod_cliente) REFERENCES cliente(codigo)
);

/************************************CATEGORIA***********************************************/

CREATE TABLE categoria (

codigo integer NOT NULL PRIMARY KEY,
nome varchar(30) NOT NULL);

/**************************************MARCA*************************************************/

CREATE TABLE marca(

codigo integer NOT NULL PRIMARY KEY,
nome varchar (45) NOT NULL);

/****************************************PRODUTO**********************************************/

CREATE TABLE produto (

codigo integer NOT NULL PRIMARY KEY,
nome varchar(30) NOT NULL,
descricao varchar(100) NOT NULL,
saldo integer NOT NULL,
valor numeric(15,2) NOT NULL,
imagem tinyblob NOT NULL,
cod_categoria integer NOT NULL,
cod_marca integer NOT NULL,
CONSTRAINT fk_prod_categoria FOREIGN KEY (cod_categoria) REFERENCES categoria(codigo),
CONSTRAINT fk_pro_marca FOREIGN KEY (cod_marca) REFERENCES marca (codigo));

/***************************************VENDA********************************************/

CREATE TABLE venda (

numero integer NOT NULL PRIMARY KEY,
cod_cliente integer NOT NULL,
dataVenda date NOT NULL,
total numeric(15,2) NOT NULL,
CONSTRAINT fk_vend_cliente FOREIGN KEY (cod_cliente) REFERENCES cliente(codigo));

/****************************************ITEMVENDA****************************************/

CREATE TABLE itemVenda (

cod_venda integer NOT NULL,
cod_produto integer NOT NULL,
quantidade integer NOT NULL,
valor numeric(15,2) NOT NULL,
desconto numeric(15,2) NOT NULL,
CONSTRAINT fk_item_venda FOREIGN KEY (cod_venda) REFERENCES venda(numero),
CONSTRAINT fk_item_produto FOREIGN KEY (cod_produto) REFERENCES produto(codigo),
PRIMARY KEY (cod_venda, cod_produto));

/***************************************SIATUACAO***************************************************/

CREATE TABLE situacao (

codigo integer NOT NULL PRIMARY KEY,
descricao varchar (45) NOT NULL );

/**************************************************************************************************/

