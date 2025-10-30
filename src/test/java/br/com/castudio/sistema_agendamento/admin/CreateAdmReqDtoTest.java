package br.com.castudio.sistema_agendamento.admin;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateAdmReqDtoTest {

    private static Validator validator;

    @BeforeAll
    static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidDto() {
        CreateAdminRequestDto dto = new CreateAdminRequestDto(
                "Matheus Augusto",
                "matheus@example.com",
                "Senha123",
                "Senha123"
        );

        Set<ConstraintViolation<CreateAdminRequestDto>> violations = validator.validate(dto);
        assertEquals(0, violations.size());
    }

    @Test
    void testInvalidName() {
        CreateAdminRequestDto dto = new CreateAdminRequestDto(
                "Matheus123",
                "matheus@example.com",
                "Senha123",
                "Senha123"
        );

        Set<ConstraintViolation<CreateAdminRequestDto>> violations = validator.validate(dto);

        boolean hasNomeInvalido = violations.stream()
                .anyMatch(v -> v.getMessage().equals("Nome invalido"));

        assertTrue(hasNomeInvalido);
    }

    @Test
    void testInvalidEmail() {
        CreateAdminRequestDto dto = new CreateAdminRequestDto(
                "Matheus Augusto",
                "matheus@exemplo",
                "Senha123",
                "Senha123"
        );

        Set<ConstraintViolation<CreateAdminRequestDto>> violations = validator.validate(dto);

        boolean hasEmailInvalido = violations.stream()
                .anyMatch(v -> v.getMessage().equals("Email invalido"));

        assertTrue(hasEmailInvalido);
    }

    @Test
    void testInvalidPassword() {
        CreateAdminRequestDto dto = new CreateAdminRequestDto(
                "Matheus Augusto",
                "matheus@example.com",
                "senha123",
                "senha123"
        );

        Set<ConstraintViolation<CreateAdminRequestDto>> violations = validator.validate(dto);

        boolean hasSenhaInvalida = violations.stream()
                .anyMatch(v -> v.getMessage().equals("Senha invalida"));

        assertTrue(hasSenhaInvalida);
    }

    @Test
    void testInvalidConfirmPassword() {
        CreateAdminRequestDto dto = new CreateAdminRequestDto(
                "Matheus Augusto",
                "matheus@example.com",
                "Senha123",
                "senha123"
        );

        Set<ConstraintViolation<CreateAdminRequestDto>> violations = validator.validate(dto);

        // Verifica se alguma violation tem a mensagem "Senha invalida"
        boolean hasConfirmSenhaInvalida = violations.stream()
                .anyMatch(v -> v.getMessage().equals("Senha invalida"));

        assertTrue(hasConfirmSenhaInvalida);
    }
}
