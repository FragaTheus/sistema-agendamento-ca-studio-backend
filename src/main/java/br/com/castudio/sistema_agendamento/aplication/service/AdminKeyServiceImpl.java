package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import org.springframework.stereotype.Service;

@Service
public class AdminKeyServiceImpl implements AdminKeyService{

    private AdminKey adminKey;

    @Override
    public boolean verifyAdminKey(String key) {
        return false;
    }
}
