package br.com.castudio.sistema_agendamento.domain.entity;

import br.com.castudio.sistema_agendamento.domain.vo.EmailVO;
import br.com.castudio.sistema_agendamento.domain.vo.PasswordVO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public class Admin {

    private UUID uuid;

    @Setter
    private String name;
    private EmailVO email;
    private PasswordVO password;

    public Admin(UUID id, String name, String email, String password){
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.email = new EmailVO(email);
        this.password = new PasswordVO(password);
    }

    public Admin(String name, String email, String password){
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.email = new EmailVO(email);
        this.password = new PasswordVO(password);
    }

    private void adminChangeEmail(String newEmail){
        this.email = new EmailVO(newEmail);
    }

    private void adminChangePassword(String newPassword){
        this.password = new PasswordVO(newPassword);
    }

}
