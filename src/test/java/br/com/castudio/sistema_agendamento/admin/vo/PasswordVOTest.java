package br.com.castudio.sistema_agendamento.admin.vo;

import br.com.castudio.sistema_agendamento.domain.vo.PasswordVO;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;


public class PasswordVOTest {


    @Test
    void createPassword(){
        String password = "MinhaSenha@2011";

        PasswordVO passwordVO = new PasswordVO(password);
        BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

        assertTrue(passwordVO.isEqual(password));
        assertFalse(passwordVO.isEqual("Outra senha"));

    }

    @Test
    void exceptionPassword(){
        assertThrows(IllegalArgumentException.class, () -> {
            new PasswordVO("Senha no formato invalido");
        });
    }

}
