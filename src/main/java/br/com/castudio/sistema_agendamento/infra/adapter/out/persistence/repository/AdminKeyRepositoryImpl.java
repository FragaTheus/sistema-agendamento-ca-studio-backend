package br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.repository;

import br.com.castudio.sistema_agendamento.domain.entity.adminkey.AdminKey;
import br.com.castudio.sistema_agendamento.infra.exceptions.DataBaseException;
import br.com.castudio.sistema_agendamento.domain.repository.adminkey.AdminKeyRepository;
import br.com.castudio.sistema_agendamento.infra.adapter.out.persistence.jpa.AdminKeyJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AdminKeyRepositoryImpl implements AdminKeyRepository {

    private final AdminKeyJpa jpa;

    @Override
    public AdminKey findById(Byte id) {
        return jpa.findById(id).orElseThrow(()-> new DataBaseException());
    }

    @Override
    public AdminKey save(AdminKey key) {
        return jpa.save(key);
    }

};
