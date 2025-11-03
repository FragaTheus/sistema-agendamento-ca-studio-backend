package br.com.castudio.sistema_agendamento.admin.services;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterResponse;
import br.com.castudio.sistema_agendamento.aplication.service.user.UserService;
import br.com.castudio.sistema_agendamento.aplication.service.authentication.register.RegisterServiceImpl;
import br.com.castudio.sistema_agendamento.aplication.service.key.KeyService;
import br.com.castudio.sistema_agendamento.domain.entity.User;
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
class RegisterServiceImplTest {

    @Mock
    private UserService userService;

    @Mock
    private KeyService keyService;

    @InjectMocks
    private RegisterServiceImpl createAdminService;

    @Test
    void shouldCreateAdminSuccessfully() {
        // given
        RegisterRequest dto = new RegisterRequest(
                "Matheus", "math@email.com", "Senha@123", "Senha@123", "123456"
        );
        User user = new User();
        User savedUser = new User();
        // mocks
        when(userService.saveAdmin(any(User.class))).thenReturn(savedUser);

        // when
        RegisterResponse response = createAdminService.createAdmin(dto);

        // then
        verify(userService).validateEmail(dto.getEmail());
        verify(userService).confirmPassword(dto);
        verify(keyService).keyIsMatch(dto.getAdminKey());
        verify(userService).saveAdmin(any(User.class));

        assertNotNull(response);
    }
}

