package br.feevale.bolao.repository;

import br.feevale.bolao.model.Bet;
import br.feevale.bolao.model.View_BetByUser;
import br.feevale.bolao.model.View_GoodBet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Long> {

    @Query(value = "SELECT idBet FROM bet WHERE idMatch = ?1 AND idUser = ?2", nativeQuery = true)
    Long findOfMatch(long idMatch, long idUser);

    @Query(value = "CALL bets_by_user( ?1 , ?2 )", nativeQuery = true)
    List<View_BetByUser> findOfUser(long idUser, int round);

    @Query(value = "SELECT * FROM vw_good_bets", nativeQuery = true)
    List<View_GoodBet> findGoodBets();
}
