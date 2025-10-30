package br.com.castudio.sistema_agendamento.aplication.service.impl;

import br.com.castudio.sistema_agendamento.aplication.service.interfaces.AdminKeyService;
import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import org.springframework.stereotype.Component;

@Component
public class AdminKeyServiceImpl implements AdminKeyService {

    //Simula admin key da base
    AdminKey currentKey = new AdminKey("AdminKey@123");

    @Override
    public boolean verifyAdminKey(String key) {
        return currentKey.verifyAdminKey(key);
    }
}
