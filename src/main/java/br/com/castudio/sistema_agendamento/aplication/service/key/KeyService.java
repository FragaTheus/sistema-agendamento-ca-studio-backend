package br.com.castudio.sistema_agendamento.aplication.service.key;

import br.com.castudio.sistema_agendamento.domain.entity.Key;

import java.util.Optional;

public interface KeyService {

    public Key createKey(String requestKey);

    public Optional<Key> getKey();

    public boolean keyIsMatch(String requestKey);

}
