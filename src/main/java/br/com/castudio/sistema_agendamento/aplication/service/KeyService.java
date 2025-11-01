package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;

import java.util.Optional;

public interface KeyService {

    public AdminKey createKey(String requestKey);

    public Optional<AdminKey> getKey();

    public boolean keyIsMatch(String requestKey);

}
