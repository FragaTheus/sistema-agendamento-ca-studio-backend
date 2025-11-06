package br.com.castudio.sistema_agendamento.usermanager.aplication.aplicationservices.profile.command;

import lombok.Builder;

@Builder
public record DeleteProfileCommand(String email, String password) {
}
