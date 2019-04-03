package br.feevale.bolao.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Auth {
    @Id
    private Long idUser;
    private String token;
    private long expiration;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }
}
