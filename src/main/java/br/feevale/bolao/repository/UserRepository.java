package br.feevale.bolao.repository;

import br.feevale.bolao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    @Query(value = "SELECT idUser, name, email, NULL AS password, NULL AS profileimg, FALSE AS is_changing_password, NULL AS token FROM user", nativeQuery = true)
    List<User> findAll();

    User findByToken(String token);
}
