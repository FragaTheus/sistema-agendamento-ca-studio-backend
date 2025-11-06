package br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.delete;

import lombok.Builder;

@Builder
public record DeleteRequest (String email, String password){
}
