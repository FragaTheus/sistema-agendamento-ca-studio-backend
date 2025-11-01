package br.com.castudio.sistema_agendamento.domain.vo;

import lombok.Getter;
import lombok.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Value
@Getter
public class PasswordVO{

    private static BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();
    String value;

    public PasswordVO(String value){
        this.value = ENCODER.encode(value);
    }

    public boolean isEqual(String password){
        String hashedPassword = ENCODER.encode(password);
        return ENCODER.matches(hashedPassword, this.value);
    }
}
