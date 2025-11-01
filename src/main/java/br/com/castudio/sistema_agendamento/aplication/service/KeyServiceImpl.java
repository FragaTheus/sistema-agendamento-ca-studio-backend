package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import br.com.castudio.sistema_agendamento.domain.exceptions.DataBaseException;
import br.com.castudio.sistema_agendamento.domain.exceptions.NotRegisteredAdminKey;
import br.com.castudio.sistema_agendamento.domain.exceptions.WrongAdminKeyException;
import br.com.castudio.sistema_agendamento.domain.repository.KeyRepository;
import br.com.castudio.sistema_agendamento.infra.repository.jpa.KeyJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class KeyServiceImpl implements KeyService{

    private final KeyRepository repository;

    @Override
    public Optional<AdminKey> selectKeyById(Long id) {
        try {
            return repository.selectKeyValue(id);
        }catch (DataBaseException e){
            throw new DataBaseException();
        }
    }

    @Override
    public boolean isMatch(String key) {
        Optional<AdminKey> currentKey = selectKeyById(1L);

        AdminKey adminKey = currentKey.orElseThrow(NotRegisteredAdminKey::new);

        if (!adminKey.verifyAdminKey(key)) {
            throw new WrongAdminKeyException();
        }
        return true;
    }




}

