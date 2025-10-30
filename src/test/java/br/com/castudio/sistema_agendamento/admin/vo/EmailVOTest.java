package br.com.castudio.sistema_agendamento.admin.vo;

import br.com.castudio.sistema_agendamento.domain.vo.EmailVO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailVOTest {

    @Test
    void createEmailVoSucessffully(){
        EmailVO email = new EmailVO("math@email.com");
        assertEquals(email.value(), "math@email.com");
    }

    @Test
    void exceptionEmail(){
        assertThrows(IllegalArgumentException.class, () -> {
            new EmailVO("email-invalido");
        });
    }

}
