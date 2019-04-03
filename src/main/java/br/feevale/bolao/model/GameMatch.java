package br.feevale.bolao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class GameMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameHome;
    private String nameVisitor;
    private Integer scoreHome;
    private Integer scoreVisitor;
    private Date played;
    private Integer round;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameHome() {
        return nameHome;
    }

    public void setNameHome(String nameHome) {
        this.nameHome = nameHome;
    }

    public String getNameVisitor() {
        return nameVisitor;
    }

    public void setNameVisitor(String nameVisitor) {
        this.nameVisitor = nameVisitor;
    }

    public Integer getScoreHome() {
        return scoreHome;
    }

    public void setScoreHome(Integer scoreHome) {
        this.scoreHome = scoreHome;
    }

    public Integer getScoreVisitor() {
        return scoreVisitor;
    }

    public void setScoreVisitor(Integer scoreVisitor) {
        this.scoreVisitor = scoreVisitor;
    }

    public Date getPlayed() {
        return played;
    }

    public void setPlayed(Date played) {
        this.played = played;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public boolean isSameScore(GameMatch m) {
        if (getScoreHome() == null) {
            return m.getScoreHome() == null;
        }

        if (getScoreVisitor() == null) {
            return m.getScoreVisitor() == null;
        }

        return getScoreHome().equals(m.getScoreHome()) && getScoreVisitor().equals(m.getScoreVisitor());
    }

    public boolean isSamePlayed(GameMatch m) {
        if (getPlayed() == null) {
            return m.getPlayed() == null;
        }

        return m.getPlayed().equals(getPlayed());
    }

    @Override
    public boolean equals(Object other) {
        GameMatch m = (GameMatch) other;

        return
                m.getRound().equals(getRound()) &&
                        m.getNameHome().equals(getNameHome()) &&
                        m.getScoreHome().equals(getScoreHome()) &&
                        isSamePlayed(m) &&
                        isSameScore(m);
    }

    @Override
    public int hashCode() {
        return getRound().hashCode() ^ getScoreHome().hashCode() ^ getNameVisitor().hashCode();
    }
}
