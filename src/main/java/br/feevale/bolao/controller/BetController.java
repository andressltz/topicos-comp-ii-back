package br.feevale.bolao.controller;

import br.feevale.bolao.model.Bet;
import br.feevale.bolao.model.View_BetByUser;
import br.feevale.bolao.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bet")
public class BetController {

    @Autowired
    private BetService service;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public void save(@RequestBody List<Bet> bets) {
        service.save(bets);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/{userId}/{round}")
    public List<View_BetByUser> getBet(@PathVariable("userId") Long userId, @PathVariable("round") Integer round) {
        return service.find(userId, round);
    }
}
