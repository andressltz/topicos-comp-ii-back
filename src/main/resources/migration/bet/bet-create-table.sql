CREATE TABLE bet (
  idBet INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  idMatch INT NOT NULL,
  idUser INT NOT NULL,
  scoreHome INT NOT NULL,
  scoreVisitor INT NOT NULL,
  dtCreated varchar(10) NOT NULL
);
