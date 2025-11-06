package br.com.castudio.sistema_agendamento.contexts.usermanager.domain.entity.adminkey;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class AdminKey {

    protected AdminKey(){}

    public AdminKey(String keyValue){
        this.keyValue = keyValue;
    }

    @Id
    @Getter
    private final Byte id = 1;

    @Getter
    @Setter
    private String keyValue;


}
