package br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.domainservice.key.command;

import lombok.Builder;

@Builder
public record ChangeKeyCommand(String currentKey, String newKey) {
}
