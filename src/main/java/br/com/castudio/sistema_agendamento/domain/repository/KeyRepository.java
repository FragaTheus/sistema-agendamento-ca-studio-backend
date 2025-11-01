package br.com.castudio.sistema_agendamento.domain.repository;

import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import br.com.castudio.sistema_agendamento.infra.repository.jpa.KeyJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class KeyRepository {

    private final KeyJpa jpa;

    public Optional<AdminKey> selectKeyValue(Long id){
        return jpa.findById(id);
    }

    public AdminKey saveKey(AdminKey key){
        return jpa.save(key);
    }

}
