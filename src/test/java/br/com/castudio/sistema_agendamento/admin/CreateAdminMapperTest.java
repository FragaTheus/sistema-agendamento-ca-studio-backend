package br.com.castudio.sistema_agendamento.admin;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminResponseDto;
import br.com.castudio.sistema_agendamento.aplication.mapper.CreateAdminMapper;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CreateAdminMapperTest {

    private CreateAdminMapper mapper;

    @BeforeEach
    void setTup(){
        mapper = new CreateAdminMapper();
    }

    @Test
    void toEntitySucessfully(){

        CreateAdminRequestDto requestDto = new CreateAdminRequestDto(
                "Nome",
                "email@email.com",
                "Senha@123",
                "Senha@123");
        Admin result = mapper.toEntity(requestDto);

        assertAll(
                ()-> assertEquals(result.getName(), "Nome"),
                ()-> assertEquals(result.getEmail().value(),"email@email.com"),
                ()-> assertTrue(BCrypt.checkpw("Senha@123", result.getPassword().value()))
        );

    }

    @Test
    void toResponseSucessfully(){

        Admin admin = new Admin(
                UUID.randomUUID(),
                "Nome",
                "email@email.com",
                "Senha@123"
        );

        CreateAdminResponseDto resultDto = mapper.toResponse(admin);

        assertAll(
                ()-> assertEquals("email@email.com", resultDto.email()),
                ()-> assertEquals("Nome", resultDto.name())
        );

    }


}
