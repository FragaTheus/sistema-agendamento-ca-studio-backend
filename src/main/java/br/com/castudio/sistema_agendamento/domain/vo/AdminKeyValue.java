package br.com.castudio.sistema_agendamento.domain.vo;

import lombok.Getter;
import lombok.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Value
@Getter
public class AdminKeyValue {

    private static BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();
    String value;

    public AdminKeyValue(String value){
        this.value = ENCODER.encode(value);
    }

    public boolean isEqual(String adminKey){
        return ENCODER.matches(adminKey, this.value);
    }

}
