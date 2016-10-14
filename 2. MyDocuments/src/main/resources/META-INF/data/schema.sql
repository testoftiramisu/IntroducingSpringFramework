CREATE TABLE types (
  typeId VARCHAR (36) NOT NULL,
  name VARCHAR (45) NOT NULL,
  description VARCHAR (255) DEFAULT NULL,
  extension VARCHAR (10) DEFAULT NULL,
  PRIMARY KEY (typeId)
);

CREATE TABLE documents (
  documentId varchar(36) NOT NULL,
  name varchar(255) NOT NULL,
  location varchar(600) NOT NULL,
  description varchar(600),
  typeId varchar(36) NOT NULL,
  created datetime NOT NULL,
  modified datetime NOT NULL,
  PRIMARY KEY (documentId),
  CONSTRAINT documentType FOREIGN KEY (typeId) REFERENCES types (typeId)
);

CREATE TABLE users (
  userId VARCHAR (36) NOT NULL,
  email VARCHAR (100) NOT NULL,
  password VARCHAR (45) NOT NULL,
  name VARCHAR (45) NOT NULL,
  userdocumentId VARCHAR (36) DEFAULT NULL,
  PRIMARY KEY (userId)
);

CREATE TABLE userdocument (
  userdocumentId VARCHAR (36) NOT NULL,
  userId VARCHAR (36) DEFAULT NULL,
  documentId VARCHAR (36) DEFAULT NULL,
  PRIMARY KEY (userdocumentId),
  CONSTRAINT users FOREIGN KEY (userId) REFERENCES users (userId) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT documents FOREIGN KEY (documentId)REFERENCES documents (documentId) ON DELETE NO ACTION ON UPDATE NO ACTION
);