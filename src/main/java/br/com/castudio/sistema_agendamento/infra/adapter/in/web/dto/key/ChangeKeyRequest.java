package br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.key;

import lombok.Builder;

@Builder
public record ChangeKeyRequest(String currentKey, String newKey) {

}
