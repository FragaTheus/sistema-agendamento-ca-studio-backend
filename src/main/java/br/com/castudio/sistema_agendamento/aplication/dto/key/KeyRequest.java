package br.com.castudio.sistema_agendamento.aplication.dto.key;

import lombok.Builder;

@Builder
public record KeyRequest(String currentKey, String newKey) {

}
