package br.com.castudio.sistema_agendamento.contexts.usermanager.domain.entity.user;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    protected User(){}

    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(UUID id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue
    @Getter
    private UUID id;

    @Getter
    @Setter
    private String name;

    @Getter
    private  String email;

    @Getter
    @Setter
    private String password;


}
