package br.com.castudio.sistema_agendamento.infra.repository;

import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KeyJpa extends JpaRepository<AdminKey, UUID> {

}
