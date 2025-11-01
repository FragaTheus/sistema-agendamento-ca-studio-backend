package br.com.castudio.sistema_agendamento.admin.services;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
import br.com.castudio.sistema_agendamento.aplication.service.AdminServiceImpl;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;
import br.com.castudio.sistema_agendamento.domain.exceptions.EmailAlreadyExistException;
import br.com.castudio.sistema_agendamento.domain.exceptions.PasswordDontMathcException;
import br.com.castudio.sistema_agendamento.domain.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

    @Mock
    private AdminRepository repository;

    @InjectMocks
    private AdminServiceImpl adminService;

    @Test
    void shoulCreateAdminTest(){
        Admin admin = new Admin();
        when(repository.saveAdmin(admin)).thenReturn(admin);

        Admin result = adminService.insertAdminInBd(admin);

        assertNotNull(result);
        assertEquals(admin, result);

    }

    @Test
    void shouldValidateEmaiTest(){
        String email = "email@email.com.br";
        when(repository.emailExists(email)).thenReturn(false);

        boolean result = adminService.validateEmail(email);
        assertFalse(result);
    }

    @Test
    void shouldEThrowExceptionTest(){
        String email = "email@email.com.br";
        when(repository.emailExists(email)).thenReturn(true);

        assertThrows(EmailAlreadyExistException.class, ()-> adminService.validateEmail(email));
    }

    @Test
    void shouldMatchInputPassowrds(){
        CreateAdminRequestDto requestDto = new CreateAdminRequestDto("",
                "",
                "Senha@123",
                "Senha123",
                "");

        assertThrows(PasswordDontMathcException.class, ()-> adminService.inputPasswordIsMatch(requestDto));

    }


}
