package br.com.castudio.sistema_agendamento.aplication.domainservice.key.contract;

import br.com.castudio.sistema_agendamento.aplication.domainservice.key.command.ChangeKeyCommand;
import br.com.castudio.sistema_agendamento.domain.entity.adminkey.AdminKey;

public interface AdminKeyService {

    public AdminKey saveAdminKey(AdminKey adminKey);

    public AdminKey findKeyById();

    public boolean validateKey(String adminKey);

    public AdminKey setKey(String newAdminKey);

    public void changeAdminKey(ChangeKeyCommand command);

}
