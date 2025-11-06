package br.com.castudio.sistema_agendamento.domain.repository.adminkey;

import br.com.castudio.sistema_agendamento.domain.entity.adminkey.AdminKey;

public interface AdminKeyRepository {

    public AdminKey findById(Byte id);

    public AdminKey save(AdminKey key);

}
