package br.feevale.bolao.repository;

import br.feevale.bolao.model.GameMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameMatchRepository extends JpaRepository<GameMatch, Long> {

    String QUERY_GAMES_BY_ROUND_AND_USER = "" +
            "SELECT g.id, g.round, g.name_home, g.name_visitor, b.scoreHome, b.scoreVisitor " +
            "FROM game_match g " +
            "LEFT JOIN bet b ON g.id = b.idMatch " +
            "WHERE g.round = ?2 " +
            "AND (b.idUser = ?1 OR b.idUser is null) " +
            "AND score_home IS NULL AND score_visitor IS NULL ";

    List<GameMatch> findByRound(Integer round);

    @Query(value = "SELECT * FROM game_match WHERE round = ?1 AND score_home IS NULL AND score_visitor IS NULL", nativeQuery = true)
    List<GameMatch> findNewGamesByRound(int round);

    @Query(value = QUERY_GAMES_BY_ROUND_AND_USER, nativeQuery = true)
    List<GameMatch> findNewGamesByRoundAndUser(int userId, int round);

    @Query(value = "SELECT DISTINCT round FROM game_match WHERE score_home IS NULL AND score_visitor IS NULL ORDER BY round ASC", nativeQuery = true)
    List<Integer> findNewRounds();

    @Query(value = "SELECT DISTINCT round FROM game_match WHERE score_home IS NOT NULL AND score_visitor IS NOT NULL ORDER BY round ASC", nativeQuery = true)
    List<Integer> findFinishedRounds();

    @Query(value = "SELECT * FROM game_match WHERE name_home = ?1 AND name_visitor = ?2", nativeQuery = true)
    GameMatch findByHomeAndVisitor(String home, String visitor);

    @Query(value = "SELECT * FROM game_match WHERE score_home IS NOT NULL AND score_visitor IS NOT NULL", nativeQuery = true)
    List<GameMatch> findFinishedMatches();

}
