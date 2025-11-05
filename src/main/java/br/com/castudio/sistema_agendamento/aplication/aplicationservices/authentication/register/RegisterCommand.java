package br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.register;

import lombok.Builder;

@Builder
public record RegisterCommand(
        String username,
        String useremail,
        String userPassword,
        String confirmPassword,
        String adminKey
) {
}
