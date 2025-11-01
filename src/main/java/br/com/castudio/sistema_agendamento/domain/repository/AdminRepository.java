package br.com.castudio.sistema_agendamento.domain.repository;

import br.com.castudio.sistema_agendamento.domain.entity.Admin;
import br.com.castudio.sistema_agendamento.infra.repository.jpa.AdminJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AdminRepository {

    private final AdminJpa jpa;

    public Admin saveAdmin(Admin admin){
        return jpa.save(admin);
    }

    public boolean emailExists(String email){
        return jpa.existsByEmail(email);
    }

}
