package br.com.castudio.sistema_agendamento.domain.vo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public record PasswordVO(String value) {

    private static BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();


    public PasswordVO{
        value = ENCODER.encode(value);
    }

    public boolean isEqual(String password){
        return ENCODER.matches(password, this.value);
    }

}
