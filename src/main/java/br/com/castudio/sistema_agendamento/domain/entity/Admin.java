package br.com.castudio.sistema_agendamento.domain.entity;

import br.com.castudio.sistema_agendamento.domain.vo.PasswordVO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
public class Admin {

    @Id
    @Column
    private UUID uuid;

    @Setter
    @Column
    private String name;

    @Column
    private String email;

    @Column
    @Embedded
    private PasswordVO password;

    public Admin(UUID id, String name, String email, String password){
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.password = new PasswordVO(password);
    }

    public Admin(String name, String email, String password){
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.password = new PasswordVO(password);

    }

    public String getPassword(){
        return password.getValue();
    }

    public void adminChangePassword(String newPassword){
        this.password = new PasswordVO(newPassword);
    }

    public boolean verifyAdminPassword(String inputPassword){
        return password.isEqual(inputPassword);
    }

}
