package br.com.castudio.sistema_agendamento.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
public class AdminKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 1L;

    @Setter
    @Column(name = "admin_key")
    private String key;

    public AdminKey(String key){
        this.key = key;
    }





}
