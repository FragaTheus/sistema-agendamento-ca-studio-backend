package br.com.castudio.sistema_agendamento.infra.repository.jpa;

import br.com.castudio.sistema_agendamento.domain.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminJpa extends JpaRepository<Admin, UUID> {

    boolean existsByEmail(String email);


}
