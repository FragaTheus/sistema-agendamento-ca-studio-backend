package br.com.castudio.sistema_agendamento.contexts.usermanager.domain.repository.adminkey;

import br.com.castudio.sistema_agendamento.contexts.usermanager.domain.entity.adminkey.AdminKey;

public interface AdminKeyRepository {

    public AdminKey findById(Byte id);

    public AdminKey save(AdminKey key);

}
