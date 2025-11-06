package br.com.castudio.sistema_agendamento.usermanager.aplication.aplicationservices.recovery.command;

import lombok.Builder;

@Builder
public record RecoveryCommand(String userEmail, String newPassword) {
}
