package br.com.castudio.sistema_agendamento.domain.repository;

import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;

public interface AdminKeyRepository {

    public AdminKey findById(Byte id);

}
