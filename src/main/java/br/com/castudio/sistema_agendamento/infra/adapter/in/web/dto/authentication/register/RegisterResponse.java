package br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.register;


import lombok.Builder;

@Builder
public record RegisterResponse(String token) {
}
