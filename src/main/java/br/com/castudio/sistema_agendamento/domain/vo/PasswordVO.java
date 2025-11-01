package br.com.castudio.sistema_agendamento.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class PasswordVO{

    private static BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();
    @Column(name = "password")
    private String value;

    public PasswordVO(String value){
        this.value = ENCODER.encode(value);
    }

    public boolean isEqual(String password){
        return ENCODER.matches(password, this.value);
    }
}
