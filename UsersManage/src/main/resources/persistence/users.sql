CREATE  TABLE USERS (
  id INT NOT NULL,
  name VARCHAR(20) NOT NULL ,
  lastname VARCHAR(40) NOT NULL,
  enable BOOLEAN NOT NULL,
  email VARCHAR(30) NOT NULL,
  PRIMARY KEY (id) );
  
  
INSERT INTO users VALUES ('0','Arquímedes','de Siracusa', true,'arq.sir@scientific.com');
INSERT INTO users VALUES ('1','Leonardo','da Vinci', true,'leo.vin@scientific.com');
INSERT INTO users VALUES ('2','Nicolás','Copérnico', true,'nic.cop@scientific.com');
INSERT INTO users VALUES ('3','Galileo','Galilei', true,'gal.gal@scientific.com');
INSERT INTO users VALUES ('4','Isaac','Newton', true,'isa.new@scientific.com');
INSERT INTO users VALUES ('5','Benjamin','Franklin', true,'ben.fra@scientific.com');
INSERT INTO users VALUES ('6','Louis','Pasteur', true,'lou.pas@scientific.com');
INSERT INTO users VALUES ('7','Nikola','Tesla', true,'nik.tes@scientific.com');
  
