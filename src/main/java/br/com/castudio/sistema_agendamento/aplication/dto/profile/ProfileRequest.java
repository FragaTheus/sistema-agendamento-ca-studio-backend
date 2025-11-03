package br.com.castudio.sistema_agendamento.aplication.dto.profile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProfileRequest{

    @Pattern(
            regexp = "^[A-Za-zÀ-ÿ\\s]+$",
            message = "Nome nao pode conter caracteres especiais"
    )
    private String name;

    @NotBlank
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,30}$",
            message = "Formato de senha invalida"
    )
    private final String currentPassword;

    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,30}$",
            message = "Formato de senha invalida"
    )
    private String newPassword;



}
