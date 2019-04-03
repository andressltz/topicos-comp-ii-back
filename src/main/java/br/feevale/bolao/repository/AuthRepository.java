package br.feevale.bolao.repository;

import br.feevale.bolao.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthRepository extends JpaRepository<Auth, Long> {

    // TODO: corrigir depois no próximo checkpoint
//    @Query(value = "SELECT IF (count(1) = 1, 'TRUE', 'FALSE') FROM auth WHERE token = ?1 AND expiration <= unix_timestamp()", nativeQuery = true)
    @Query(value = "SELECT IF (count(1) = 1, 'TRUE', 'FALSE') FROM auth WHERE token = ?1", nativeQuery = true)
    boolean isTokenValid(String token);

    void deleteByToken(String token);

    Auth findByToken(String token);
}
