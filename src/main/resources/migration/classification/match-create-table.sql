CREATE TABLE game_match (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  round INT NOT NULL,
  name_home VARCHAR(255) NOT NULL,
  name_visitor VARCHAR(255) NOT NULL,
  score_home INT NULL,
  score_visitor INT NULL,
  date VARCHAR(10) NOT NULL
);
