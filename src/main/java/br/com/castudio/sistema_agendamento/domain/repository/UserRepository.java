package br.com.castudio.sistema_agendamento.domain.repository;

import br.com.castudio.sistema_agendamento.domain.entity.User;
import java.util.Optional;


public interface UserRepository {

    public User save(User user);

    public boolean existsByEmail(String email);

    public Optional<User> findByEmail(String email);

}
