package br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.profile.command;

import lombok.Builder;

@Builder
public record UpdateProfileCommand(String name, String email ,String currentPassword, String newPassword) {
}
