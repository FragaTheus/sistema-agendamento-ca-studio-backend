package br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.response;

import lombok.Builder;

@Builder
public record ProcedureResponse(Long id, String name, Integer duration) {
}
