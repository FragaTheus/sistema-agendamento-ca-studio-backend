package br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.jpa;

import br.com.castudio.sistema_agendamento.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpa extends JpaRepository<User, UUID> {

    public boolean existsByEmail(String email);

    public Optional<User> findByEmail(String email);

}
