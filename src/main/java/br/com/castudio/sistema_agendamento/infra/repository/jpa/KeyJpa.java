package br.com.castudio.sistema_agendamento.infra.repository.jpa;

import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KeyJpa extends JpaRepository<AdminKey, Long> {



}
