DELIMITER //
DROP PROCEDURE IF EXISTS bets_by_user //
create procedure
  bets_by_user(p_idUser int, p_round int)
begin
select
    m.id idMatch,
    m.name_home nameHome,
    m.name_visitor nameVisitor,
    m.score_home actualScoreHome,
    m.score_visitor actualScoreVisitor,
    b.scoreHome betScoreHome,
    b.scoreVisitor betScoreVisitor
from
    game_match m
    left join (
        select *
        from bet
        where idUser = p_idUser
    ) b on b.idMatch = m.id
where
    m.round = p_round;
end
//