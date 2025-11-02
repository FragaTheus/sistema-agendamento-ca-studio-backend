package br.com.castudio.sistema_agendamento.aplication.dto.authentication.register;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RegisterRequest {

    @NotBlank
    @Pattern(
            regexp = "^[A-Za-zÀ-ÿ\\s]+$",
            message = "Nome nao pode conter caracteres especiais"
    )
    String name;

    @NotBlank
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Formato de email invalido"
    )
    String email;

    @NotBlank
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,30}$",
            message = "Formato de senha invalida"
    )
    String password;

    @NotBlank
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,30}$",
            message = "Formato de senha invalida"
    )
    String confirmPassword;

    @NotBlank
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,30}$",
            message = "Formato de chave invalida"
    )
    String adminKey;

}
