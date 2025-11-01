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
public class AdminKeyValue {

    private static BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Column(name = "key_value")
    private String value;

    public AdminKeyValue(String value){
        this.value = ENCODER.encode(value);
    }

    public boolean isEqual(String adminKey){
        return ENCODER.matches(adminKey, this.value);
    }

}
