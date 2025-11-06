package br.com.castudio.sistema_agendamento.usermanager.aplication.aplicationservices.register.command;

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
