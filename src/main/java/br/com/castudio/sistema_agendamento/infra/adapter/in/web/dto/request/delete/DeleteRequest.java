package br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.request.delete;

import lombok.Builder;

@Builder
public record DeleteRequest (String email, String password){
}
