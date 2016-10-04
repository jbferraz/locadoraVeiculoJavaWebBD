CREATE TABLE categoriaVeiculo (
  idCatVeiculo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  descCatVeiculo VARCHAR(20) NOT NULL,
  catAtivo boolean,
  PRIMARY KEY(idCatVeiculo)
);

CREATE TABLE Cliente (
  idCliente INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nomeCliente VARCHAR(45) NOT NULL,
  CPF VARCHAR(45)  NOT NULL,
  endereco VARCHAR(255) NOT NULL,
  celular VARCHAR(45) NOT NULL,
  telefone VARCHAR(45) NULL,
  email VARCHAR(255) NOT NULL,
  dataNascimento DATE NOT NULL,
  sexo CHAR(1) NOT NULL,
  cliAtivo Boolean, 
  PRIMARY KEY(idCliente)
);

CREATE TABLE Locacao (
  idLocacao INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Cliente_idCliente INTEGER UNSIGNED NOT NULL,
  Veiculo_idVeiculo INTEGER UNSIGNED NOT NULL,
  dataLocacao TIMESTAMP NOT NULL,
  dataRetirada DATE NOT NULL,
  dataDevolucao DATE NULL,
  kmRetirada INTEGER UNSIGNED NULL,
  kmDevolucao INTEGER UNSIGNED NULL,
  kmLivre BOOLean NULL,
  status BOOLean NULL,
  PRIMARY KEY(idLocacao),
  INDEX Locacao_FKIndex1(Cliente_idCliente),
  INDEX Locacao_FKIndex2(Veiculo_idVeiculo)
);

CREATE TABLE Marca (
  idMarca INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nomeMarca VARCHAR(20) NOT NULL,
  marcaAtiva boolean,
  PRIMARY KEY(idMarca)
);



CREATE TABLE Veiculo (
  idVeiculo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  categoriaVeiculo_idCatVeiculo INTEGER UNSIGNED NOT NULL,
  marca_idMarca INTEGER UNSIGNED NOT NULL,
  modelo VARCHAR(20) NOT NULL,
  ano INTEGER UNSIGNED NOT NULL,
  cor VARCHAR(20) NOT NULL,
  portas INTEGER UNSIGNED NOT NULL,
  opcionais VARCHAR(255) NULL,
  placa VARCHAR(7) NOT NULL,
  valorLivre INTEGER UNSIGNED NOT NULL,
  valorKm NUMERIC NOT NULL,
  disponivel BOOLean NULL,
  veicAtivo boolean,
  PRIMARY KEY(idVeiculo),
  INDEX Veiculo_FKIndex1(marca_idMarca),
  INDEX Veiculo_FKIndex2(categoriaVeiculo_idCatVeiculo)
);

