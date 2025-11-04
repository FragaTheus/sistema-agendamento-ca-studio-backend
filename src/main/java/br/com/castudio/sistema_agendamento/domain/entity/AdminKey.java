package br.com.castudio.sistema_agendamento.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class AdminKey {

    protected AdminKey(){}

    public AdminKey(String value){
        this.value = value;
    }

    @Id
    @Getter
    private final Byte id = 1;

    @Getter
    @Setter
    private String value;


}
