package br.feevale.bolao.service;

import br.feevale.bolao.model.Auth;
import br.feevale.bolao.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.UUID;

@Component
public class AuthService {
    @Autowired
    AuthRepository repository;

    public boolean isAuthorized(String token) {
        return repository.isTokenValid(token);
    }

    public Long getAuthorizedUserId(String token) {
        if (isAuthorized(token)) {
            return repository.findByToken(token).getIdUser();
        }
        return null;
    }

    public String authorize(long idUser) {
        try {
            repository.deleteById(idUser);
        } catch (EmptyResultDataAccessException ex) {
            // ignore!
        }

        Auth auth = new Auth();
        auth.setIdUser(idUser);
        auth.setToken(UUID.randomUUID().toString());
        auth.setExpiration(Instant.now().getEpochSecond() + 3600);

        repository.save(auth);

        return auth.getToken();
    }

    @Transactional
    public void removeAuth(String token) {
        try {
            repository.deleteByToken(token);
        } catch (EmptyResultDataAccessException ex) {
            // ignore!
        }
    }
}
