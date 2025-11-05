package br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.recovery;

import lombok.Builder;

@Builder
public record RecoveryCommand(String userEmail, String newPassword) {
}
