package br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.login;

import lombok.Builder;

@Builder
public record LoginCommand(String useremail, String userPassword) {
}
