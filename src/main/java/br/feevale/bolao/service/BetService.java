package br.feevale.bolao.service;

import br.feevale.bolao.model.Bet;
import br.feevale.bolao.model.View_BetByUser;
import br.feevale.bolao.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Component
public class BetService {

    @Autowired
    BetRepository repository;

    public void save(List<Bet> bets) {
        for (Bet bet : bets) {
            if (bet.getScoreHome() == null || bet.getScoreVisitor() == null) {
                continue;
            }

            bet.setCreated(Date.from(Instant.now()));

            Long id = repository.findOfMatch(bet.getIdMatch(), bet.getIdUser());

            if (id != null) {
                bet.setId(id);
            }

            repository.save(bet);
        }
    }

    public List<View_BetByUser> find(long user, int round) {
        return repository.findOfUser(user, round);
    }

}
