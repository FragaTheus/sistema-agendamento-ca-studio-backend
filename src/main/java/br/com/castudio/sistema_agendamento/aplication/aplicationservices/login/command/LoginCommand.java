package br.com.castudio.sistema_agendamento.aplication.aplicationservices.login.command;

import lombok.Builder;

@Builder
public record LoginCommand(String useremail, String userPassword) {
}
