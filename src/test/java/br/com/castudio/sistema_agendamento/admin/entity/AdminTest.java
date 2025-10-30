package br.com.castudio.sistema_agendamento.admin.entity;

import br.com.castudio.sistema_agendamento.domain.entity.Admin;
import br.com.castudio.sistema_agendamento.domain.vo.PasswordVO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdminTest {

    @Test
    void createAdminTestWithPassword(){
        assertThrows(IllegalArgumentException.class, () -> {
            Admin admin = new Admin("Nome", "senhainvalida", "email@email.com");
        });
    }

    @Test
    void createAdminTestWithEmail(){
        assertThrows(IllegalArgumentException.class, () -> {
            Admin admin = new Admin("Nome", "Senha@2011", "emailemail.com");
        });
    }

}
