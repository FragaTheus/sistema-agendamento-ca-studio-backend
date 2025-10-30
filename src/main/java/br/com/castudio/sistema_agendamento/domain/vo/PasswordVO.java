package br.com.castudio.sistema_agendamento.domain.vo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public record PasswordVO(String value) {

    private static BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();
    private static String REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\n";

    public PasswordVO{
        if (value == null || !REGEX.matches(value)){
            throw new IllegalArgumentException("Senha invalida");
        }
            value = ENCODER.encode(value);
    }

    public boolean isEqual(String password){
        return ENCODER.matches(password, this.value);
    }

}
