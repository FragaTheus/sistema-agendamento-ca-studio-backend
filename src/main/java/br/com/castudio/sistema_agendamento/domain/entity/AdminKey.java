package br.com.castudio.sistema_agendamento.domain.entity;

import br.com.castudio.sistema_agendamento.domain.vo.AdminKeyValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
public class AdminKey {

    @Id
    private Long id = 1L;

    @Embedded
    private AdminKeyValue adminKeyValue;

    public AdminKey(String key){
        this.adminKeyValue = new AdminKeyValue(key);
    }

    public void changeAdminKey(String key){
        this.adminKeyValue = new AdminKeyValue(key);
    }

    public boolean verifyAdminKey(String key){
        return adminKeyValue.isEqual(key);
    }

    public String getKey(){
        return adminKeyValue.getValue();
    }
}
