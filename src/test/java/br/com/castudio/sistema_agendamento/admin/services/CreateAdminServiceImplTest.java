package br.com.castudio.sistema_agendamento.admin.services;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminResponseDto;
import br.com.castudio.sistema_agendamento.aplication.service.AdminService;
import br.com.castudio.sistema_agendamento.aplication.service.CreateAdminServiceImpl;
import br.com.castudio.sistema_agendamento.aplication.service.KeyService;
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
class CreateAdminServiceImplTest {

    @Mock
    private AdminService adminService;

    @Mock
    private KeyService keyService;

    @InjectMocks
    private CreateAdminServiceImpl createAdminService;

    @Test
    void shouldCreateAdminSuccessfully() {
        // given
        CreateAdminRequestDto dto = new CreateAdminRequestDto(
                "Matheus", "math@email.com", "Senha@123", "Senha@123", "123456"
        );
        Admin admin = new Admin();
        Admin savedAdmin = new Admin();
        // mocks
        when(adminService.insertAdminInBd(any(Admin.class))).thenReturn(savedAdmin);

        // when
        CreateAdminResponseDto response = createAdminService.createAdmin(dto);

        // then
        verify(adminService).validateEmail(dto.getEmail());
        verify(adminService).inputPasswordIsMatch(dto);
        verify(keyService).isMatch(dto.getAdminKey());
        verify(adminService).insertAdminInBd(any(Admin.class));

        assertNotNull(response);
    }
}

