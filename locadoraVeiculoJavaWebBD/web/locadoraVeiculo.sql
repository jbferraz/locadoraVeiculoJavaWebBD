CREATE TABLE categoriaVeiculo (
  idCatVeiculo serial  NOT NULL,
  descCatVeiculo VARCHAR(20) NOT NULL,
  catAtivo boolean,
  PRIMARY KEY(idCatVeiculo)
);

CREATE TABLE Cliente (
  idCliente serial NOT NULL,
  nomeCliente VARCHAR(45) NOT NULL,
  CPF VARCHAR(45)  NOT NULL,
  endereco VARCHAR(255) NOT NULL,
  celular VARCHAR(45) NOT NULL,
  telefone VARCHAR(45) NULL,
  email VARCHAR(255) NOT NULL,
  dataNascimento DATE NOT NULL,
  sexo CHAR(1) NOT NULL,
  login varchar(45),
  senha varchar(255),
  cliAtivo Boolean, 
  PRIMARY KEY(idCliente)
);

CREATE TABLE Marca (
  idMarca serial  NOT NULL ,
  nomeMarca VARCHAR(20) NOT NULL,
  marcaAtiva boolean,
  PRIMARY KEY(idMarca)
);

CREATE TABLE Veiculo (
  idVeiculo serial  NOT NULL ,
  idCatVeiculo INTEGER  NOT NULL references categoriaVeiculo,
  idMarca INTEGER  NOT NULL references Marca,
  modelo VARCHAR(20) NOT NULL,
  ano INTEGER  NOT NULL,
  cor VARCHAR(20) NOT NULL,
  portas INTEGER  NOT NULL,
  opcionais VARCHAR(255) NULL,
  placa VARCHAR(7) NOT NULL,
  valorLivre INTEGER  NOT NULL,
  valorKm NUMERIC NOT NULL,
  disponivel BOOLean NULL,
  veicAtivo boolean,
  PRIMARY KEY(idVeiculo)
);

CREATE TABLE Locacao (
  idLocacao serial NOT NULL ,
  idCliente INTEGER  NOT NULL references Cliente,
  idVeiculo INTEGER  NOT NULL references Veiculo,
  dataLocacao TIMESTAMP NOT NULL,
  dataRetirada DATE NOT NULL,
  dataDevolucao DATE NULL,
  kmRetirada INTEGER  NULL,
  kmDevolucao INTEGER  NULL,
  kmLivre BOOLean NULL,
  status BOOLean NULL,
  PRIMARY KEY(idLocacao)
);
