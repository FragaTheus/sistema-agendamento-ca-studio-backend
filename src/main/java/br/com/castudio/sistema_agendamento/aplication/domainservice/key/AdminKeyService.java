package br.com.castudio.sistema_agendamento.aplication.domainservice.key;

import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;

public interface AdminKeyService {

    public AdminKey findKeyById();

    public void keyIsMatch(String adminKey, String confirmAdminKey);

    public AdminKey setKey(String newAdminKey);

    public void changeAdminKey(ChangeKeyCommand command);

}
