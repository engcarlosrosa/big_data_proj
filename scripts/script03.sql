DROP DATABASE IF EXISTS RHCONTROLLER;
CREATE DATABASE RHCONTROLLER;
USE RHCONTROLLER;

CREATE TABLE DADOS_PESSOAIS(
	ID_FUNCIONARIO INT NOT NULL AUTO_INCREMENT,
	NOME VARCHAR(80) NOT NULL UNIQUE,
    NASCIMENTO DATE,
    RG INT NOT NULL,
    ORGAO VARCHAR(10) NOT NULL,
    CPF VARCHAR(11) NOT NULL,
    NACIONALIDADE VARCHAR(20),
    ENDERECO VARCHAR(200),
    CONTATO VARCHAR(30),
    NOME_PAI VARCHAR(80),
    NOME_MAE VARCHAR(80),
    DADOS_BANCARIOS VARCHAR(80),
    PRIMARY KEY (ID_FUNCIONARIO)
    );
    
CREATE TABLE PAGAMENTOS(
	ID_PAGAMENTO INT NOT NULL AUTO_INCREMENT UNIQUE,
	ID_FUNCIONARIO INT NOT NULL,
    VALOR DECIMAL(10,2),
    DIA DATE,
    TIPO VARCHAR(20),
    PRIMARY KEY (ID_PAGAMENTO),
    FOREIGN KEY(ID_FUNCIONARIO)
		REFERENCES DADOS_PESSOAIS(ID_FUNCIONARIO)
    );
    
CREATE TABLE BENEFICIOS(
	ID_BENEFICIO INT NOT NULL AUTO_INCREMENT UNIQUE,
    NOME VARCHAR(20),
    PRIMARY KEY (ID_BENEFICIO)
    );

CREATE TABLE FUNCIONARIOS_BENEFICIOS_REL(
	ID_BENEFICIO INT NOT NULL,
    ID_FUNCIONARIO INT NOT NULL,
    VALOR DECIMAL(10,2),
    PRIMARY KEY (ID_BENEFICIO, ID_FUNCIONARIO),
    FOREIGN KEY (ID_BENEFICIO)
		REFERENCES BENEFICIOS(ID_BENEFICIO),
	FOREIGN KEY (ID_FUNCIONARIO)
		REFERENCES DADOS_PESSOAIS(ID_FUNCIONARIO)
	);

CREATE TABLE FALTAS(
	ID_FALTA INT NOT NULL AUTO_INCREMENT UNIQUE,
	ID_FUNCIONARIO INT NOT NULL,
    DIA DATE,
    MOTIVO VARCHAR(160),
    ABONO INT,
    PRIMARY KEY (ID_FALTA),
    FOREIGN KEY (ID_FUNCIONARIO)
		REFERENCES DADOS_PESSOAIS(ID_FUNCIONARIO)
	);
    
    
    