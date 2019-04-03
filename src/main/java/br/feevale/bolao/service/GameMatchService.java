package br.feevale.bolao.service;

import br.feevale.bolao.model.GameMatch;
import br.feevale.bolao.repository.GameMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameMatchService {

    @Autowired
    GameMatchRepository repository;

    public List<GameMatch> findNewGamesByRound(int round) {
        return repository.findNewGamesByRound(round);
    }

    public List<GameMatch> findNewGamesByRoundAndUser(int userId, int round) {
//        return repository.findNewGamesByRoundAndUser(userId, round);
        return repository.findNewGamesByRound(round);
    }

    public List<Integer> findNewRounds() {
        return repository.findNewRounds();
    }

    public List<Integer> findFinishedRounds() {
        return repository.findFinishedRounds();
    }

}
