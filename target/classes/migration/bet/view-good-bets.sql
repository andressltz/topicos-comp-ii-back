--liquibase formatted sql
--changeset includeAll:view_good_bets

DELETE FROM bet;
ALTER TABLE bet DROP COLUMN dtCreated;
ALTER TABLE bet ADD created TIMESTAMP NOT NULL;
DELETE FROM game_match;
ALTER TABLE game_match DROP COLUMN `date`;
ALTER TABLE game_match ADD played TIMESTAMP NULL;

CREATE VIEW vw_good_bets AS
  SELECT
    m.id matchId,
    u.idUser userId
  FROM
    bet b
    JOIN game_match m ON b.idMatch = m.id
    JOIN user u ON b.idUser = u.idUser
  WHERE
    b.scoreHome = m.score_home
    AND b.scoreVisitor = m.score_visitor
    AND b.created < m.played;
