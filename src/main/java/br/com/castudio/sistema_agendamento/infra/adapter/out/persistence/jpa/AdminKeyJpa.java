package br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.jpa;

import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminKeyJpa extends JpaRepository<AdminKey, Byte> {
}
