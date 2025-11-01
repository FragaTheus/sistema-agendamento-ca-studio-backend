package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;

import java.util.Optional;

public interface KeyService {

    public Optional<AdminKey> selectKeyById(Long id);

    public boolean isMatch(String key);

}
