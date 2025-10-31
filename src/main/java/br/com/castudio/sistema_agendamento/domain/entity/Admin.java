package br.com.castudio.sistema_agendamento.domain.entity;

import br.com.castudio.sistema_agendamento.domain.vo.EmailVO;
import br.com.castudio.sistema_agendamento.domain.vo.PasswordVO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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
    @Convert(converter = EmailVO.class)
    private EmailVO email;

    @Column
    @Convert(converter = EmailVO.class)
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


    public String getAdminEmail(){
        return this.email.getEmailValue();
    }

    public String getAdminsPassword(){
        return this.password.getPasswordValue();
    }

    public void adminChangeEmail(String newEmail){
        this.email = new EmailVO(newEmail);
    }

    public void adminChangePassword(String newPassword){
        this.password = new PasswordVO(newPassword);
    }

    public boolean verifyAdminPassword(String inputPassword){
        return password.isEqual(inputPassword);
    }

}
