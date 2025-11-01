package br.com.castudio.sistema_agendamento.admin.vo;

import br.com.castudio.sistema_agendamento.domain.entity.Admin;
import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static org.junit.jupiter.api.Assertions.*;

public class AdminKeyTest {

    BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Test
    void shoulCreateAdminKeyWithHash(){
        AdminKey adminKey = new AdminKey("ChaveComHash");

        assertAll(
                ()->assertTrue(ENCODER.matches("ChaveComHash", adminKey.getKey())),
                ()->assertFalse(ENCODER.matches("ChaveErrada", adminKey.getKey()))
        );
    }

    @Test
    void shoulMatchAdminKeys(){
        AdminKey adminKey = new AdminKey("ChaveComHash");
        String match = "ChaveComHash";
        String dontMatch = "QualquerSenha";

        assertAll(
                ()-> assertTrue(adminKey.verifyAdminKey(match)),
                ()-> assertFalse(adminKey.verifyAdminKey(dontMatch))
        );
    }

}
