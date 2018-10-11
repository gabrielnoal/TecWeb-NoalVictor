# TecWeb-WarlenNoal
Projeto CRUD de Tecnologias Web.

------ CRIANDO BASE DE DADOS MySQL ------

CREATE DATABASE crudproject;

CREATE TABLE user  (
user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(20) NOT NULL, 
surname VARCHAR(20), 
username VARCHAR(15) NOT NULL UNIQUE, 
age INT(2), 
email VARCHAR(89),
password VARCHAR(50) NOT NULL
);

CREATE TABLE note (
note_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
title VARCHAR(50), 
content TEXT NOT NULL, 
user_id INT REFERENCES user(user_id)
);
