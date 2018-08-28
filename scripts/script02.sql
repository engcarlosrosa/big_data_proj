USE RHCONTROLLER;

CREATE TABLE DADOS_PESSOAIS(
	ID_COLABORADOR INT NOT NULL AUTO_INCREMENT,
    NOME VARCHAR(50),
    NASCIMENTO DATE,
    ESTADO_CIVIL INT NOT NULL,
    SEXO INT NOT NULL,
    NOME_PAI VARCHAR(50),
    NOME_MAE VARCHAR(50),
    RG INT NOT NULL,
    ORGAO_EMISSOR VARCHAR(10),
    CPF INT NOT NULL,
    PRIMARY KEY (ID_COLABORADOR),
    CONSTRAINT FK_ESTADO_CIVIL FOREIGN KEY (ESTADO_CIVIL)
		REFERENCES ESTADO_CIVIL(ID_ESTADO_CIVIL),
	CONSTRAINT FK_SEXO FOREIGN KEY (SEXO)
		REFERENCES SEXO(SEXO_ID)
        );
	