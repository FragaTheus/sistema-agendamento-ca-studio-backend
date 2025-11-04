package br.com.castudio.sistema_agendamento.aplication.service.key;

import br.com.castudio.sistema_agendamento.aplication.dto.key.KeyRequest;
import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;

import java.util.Optional;

public interface KeyService {

    public AdminKey insertKey(String requestKey);

    public Optional<AdminKey> getKey();

    public boolean keyIsMatch(String requestKey);

    public AdminKey setKey(KeyRequest request);

}
