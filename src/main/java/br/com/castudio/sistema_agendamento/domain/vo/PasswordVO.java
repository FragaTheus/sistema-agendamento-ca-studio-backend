package br.com.castudio.sistema_agendamento.domain.vo;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Converter(autoApply = true)
public record PasswordVO(String value) implements AttributeConverter<PasswordVO, String> {

    private static BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();


    public PasswordVO{
        value = ENCODER.encode(value);
    }

    public boolean isEqual(String password){
        String hashePassword = ENCODER.encode(password);
        return ENCODER.matches(hashePassword, this.value);
    }

    public String getPasswordValue(){
        return this.value;
    }

    @Override
    public String convertToDatabaseColumn(PasswordVO password) {
        return password == null ? null : password.value();
    }

    @Override
    public PasswordVO convertToEntityAttribute(String password) {
        return password == null ? null : new PasswordVO(password);
    }
}
