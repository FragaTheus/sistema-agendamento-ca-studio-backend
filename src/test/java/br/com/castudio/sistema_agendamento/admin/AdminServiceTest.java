package br.com.castudio.sistema_agendamento.admin;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminResponseDto;
import br.com.castudio.sistema_agendamento.aplication.service.AdminServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdminServiceTest {

    private AdminServiceImpl service;

    @BeforeEach
    void setUp(){
        service = new AdminServiceImpl();
    }

    @Test
    void createSucessfullyAdmin(){
        CreateAdminRequestDto requestDto = new CreateAdminRequestDto(
                "Nome",
                "email@email.com",
                "Senha@123",
                "Senha@123"
        );

        CreateAdminResponseDto admin = service.createAdmin(requestDto);

        assertAll(
                ()-> assertNotNull(admin),
                ()-> assertEquals("Nome", admin.name()),
                ()-> assertEquals("email@email.com", admin.email())
        );

    }

    @Test
    void registeredAdmin(){
        CreateAdminRequestDto requestDto = new CreateAdminRequestDto(
                "Nome",
                "email@email.com",
                "Senha@123",
                "Senha@123"
        );

        CreateAdminRequestDto requestDto1 = new CreateAdminRequestDto(
                "Nome",
                "email@email.com",
                "Senha@123",
                "Senha@123"
        );

        service.createAdmin(requestDto);

        assertThrows(RuntimeException.class, ()-> service.createAdmin(requestDto1));
    }

    @Test
    void passwordNotMatch(){
        CreateAdminRequestDto requestDto = new CreateAdminRequestDto(
                "Nome",
                "email@email.com",
                "Senha@123",
                "Senha@456"
        );

        assertThrows(RuntimeException.class, ()-> service.createAdmin(requestDto));
    }

    @Test
    void verifyEmailTest(){
        CreateAdminRequestDto requestDto = new CreateAdminRequestDto(
                "Nome",
                "email@email.com",
                "Senha@123",
                "Senha@123"
        );

        service.createAdmin(requestDto);

        assertAll(
                ()-> assertTrue(service.verifyEmail("email@email.com")),
                ()-> assertFalse(service.verifyEmail("meuemail@email.com"))
        );
    }

    @Test
    void verifyPassowordTest(){
        CreateAdminRequestDto requestDto = new CreateAdminRequestDto(
                "Nome",
                "email@email.com",
                "Senha@123",
                "Senha@123"
        );

        assertTrue(service.verifyPassword(requestDto));

        CreateAdminRequestDto wrongReqDto = new CreateAdminRequestDto(
                "Nome",
                "email@email.com",
                "Senha@123",
                "Senha@678"
        );

        assertFalse(service.verifyPassword(wrongReqDto));
    }

}
