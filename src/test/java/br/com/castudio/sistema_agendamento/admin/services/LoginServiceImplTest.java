package br.com.castudio.sistema_agendamento.admin.services;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterResponse;
import br.com.castudio.sistema_agendamento.aplication.service.user.UserService;
import br.com.castudio.sistema_agendamento.aplication.service.login.LoginServiceImpl;
import br.com.castudio.sistema_agendamento.aplication.service.key.KeyService;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginServiceImplTest {

    @Mock
    private UserService userService;

    @Mock
    private KeyService keyService;

    @InjectMocks
    private LoginServiceImpl createAdminService;

    @Test
    void shouldCreateAdminSuccessfully() {
        // given
        RegisterRequest dto = new RegisterRequest(
                "Matheus", "math@email.com", "Senha@123", "Senha@123", "123456"
        );
        Admin admin = new Admin();
        Admin savedAdmin = new Admin();
        // mocks
        when(userService.saveAdmin(any(Admin.class))).thenReturn(savedAdmin);

        // when
        RegisterResponse response = createAdminService.createAdmin(dto);

        // then
        verify(userService).validateEmail(dto.getEmail());
        verify(userService).confirmPassword(dto);
        verify(keyService).keyIsMatch(dto.getAdminKey());
        verify(userService).saveAdmin(any(Admin.class));

        assertNotNull(response);
    }
}

