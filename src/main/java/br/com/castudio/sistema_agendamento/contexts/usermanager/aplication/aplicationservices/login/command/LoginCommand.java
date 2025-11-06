package br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.login.command;

import lombok.Builder;

@Builder
public record LoginCommand(String useremail, String userPassword) {
}
