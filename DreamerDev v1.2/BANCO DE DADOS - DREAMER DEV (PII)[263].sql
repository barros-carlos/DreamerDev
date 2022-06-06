show databases;
create database Jogo;
use Jogo;
create table Jogadores (
	codJogador INTEGER UNIQUE NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nickJogador VARCHAR(10) UNIQUE NOT NULL,
    senhaJogador CHAR(20) NOT NULL);


create table Ranking (
	codRanking INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tempo TIME NOT NULL,
    miliseconds INTEGER not null,
    codJogador INTEGER,
    FOREIGN KEY (codJogador) REFERENCES Jogadores(codJogador));

