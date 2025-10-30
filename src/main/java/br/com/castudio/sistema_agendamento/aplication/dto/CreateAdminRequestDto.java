package br.com.castudio.sistema_agendamento.aplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateAdminRequestDto {

    @NotBlank
    @Pattern(
            regexp = "^[A-Za-zÀ-ÿ\\s]+$",
            message = "Nome invalido"
    )
    String name;

    @NotBlank
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Email invalido"
    )
    String email;

    @NotBlank
    @Pattern(
            regexp = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[^a-zA-Z0-9]).{8,30}$",
            message = "Senha invalida"
    )
    String password;

    @NotBlank
    @Pattern(
            regexp = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[^a-zA-Z0-9]).{8,30}$",
            message = "Senha invalida"
    )
    String confirmPassword;

}
