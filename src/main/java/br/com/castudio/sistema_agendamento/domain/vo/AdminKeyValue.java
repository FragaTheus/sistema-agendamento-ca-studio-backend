package br.com.castudio.sistema_agendamento.domain.vo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public record AdminKeyValue(String value) {

    private static BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    public AdminKeyValue{
        value = ENCODER.encode(value);
    }

    public boolean isEqual(String adminKey){
        return ENCODER.matches(value, adminKey);
    }

    public String getADminKeyValue(){
        return this.value;
    }

}
