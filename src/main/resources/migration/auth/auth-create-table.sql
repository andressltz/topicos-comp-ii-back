CREATE TABLE auth (
  id_user INT NOT NULL REFERENCES user (idUser),
  token VARCHAR(36) NOT NULL,
  expiration BIGINT NOT NULL,
  UNIQUE (id_user)
);
