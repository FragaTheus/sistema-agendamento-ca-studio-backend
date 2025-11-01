package br.com.castudio.sistema_agendamento.admin.vo;

import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import br.com.castudio.sistema_agendamento.domain.vo.PasswordVO;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordVOTest {

    BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Test
    void shoulCreatePasswordWithHash(){
        PasswordVO passwordVO = new PasswordVO("SenhaQueTemQueHashar");

        assertAll(
                ()->assertTrue(ENCODER.matches("SenhaQueTemQueHashar",passwordVO.getValue())),
                ()->assertFalse(ENCODER.matches("SenhaErrada", passwordVO.getValue()))
        );

    }

   @Test
    void shouldMatchPasswordsHashes(){
        PasswordVO password = new PasswordVO("SenhaQueTemQueHashar");
        String correctPasswordFromReqDto = "SenhaQueTemQueHashar";
        String wrongPasswordFromReqDto = "SenhaErrada";

        assertAll(
                ()->assertTrue(password.isEqual(correctPasswordFromReqDto)),
                ()->assertFalse(password.isEqual(wrongPasswordFromReqDto))
        );
   }

}
