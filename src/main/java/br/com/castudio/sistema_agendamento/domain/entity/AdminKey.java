package br.com.castudio.sistema_agendamento.domain.entity;

import br.com.castudio.sistema_agendamento.domain.vo.AdminKeyValue;

import java.util.UUID;

public class AdminKey {

    private UUID uuid;
    private AdminKeyValue adminKeyValue;

    public AdminKey(String key){
        this.uuid = UUID.randomUUID();
        this.adminKeyValue = new AdminKeyValue(key);
    }

}
