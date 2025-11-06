package br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.jpa.adminkey;

import br.com.castudio.sistema_agendamento.contexts.usermanager.domain.entity.adminkey.AdminKey;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminKeyJpa extends JpaRepository<AdminKey, Byte> {
}
