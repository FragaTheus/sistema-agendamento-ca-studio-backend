package br.com.castudio.sistema_agendamento.domain.repository;

import br.com.castudio.sistema_agendamento.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdminRepository extends JpaRepository<User, UUID> {

    public boolean existsByEmail(String email);

    public Optional<User> findByEmail(String email);
}
