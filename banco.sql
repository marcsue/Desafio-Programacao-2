CREATE DATABASE desafio2;
	
CREATE TABLE Departamento
(
	id integer NOT NULL,
	nome varchar (15) NOT NULL,

	CONSTRAINT DepPK PRIMARY KEY (id)
);

CREATE TABLE Funcionario
(
	id integer NOT NULL,
	nome varchar(30) NOT NULL, 
	cargo varchar(30),
	idade integer, 
	salario real,
	idDepartamento integer NOT NULL,
	
	CONSTRAINT FunPk PRIMARY KEY (id),
	CONSTRAINT FunFKEmp FOREIGN KEY (idDepartamento) REFERENCES Departamento (id)
);

