package br.com.castudio.sistema_agendamento.aplication.domainservice.key;

import lombok.Builder;

@Builder
public record ChangeKeyCommand(String currentKey, String newKey) {
}
