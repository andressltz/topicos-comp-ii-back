package br.feevale.bolao.model;

public interface View_BetByUser {
    Long getIdMatch();

    String getNameHome();

    String getNameVisitor();

    Integer getActualScoreHome();

    Integer getActualScoreVisitor();

    Integer getBetScoreHome();

    Integer getBetScoreVisitor();
}
