package br.com.castudio.sistema_agendamento.aplication.dto.authentication.register;


import lombok.Builder;

@Builder
public record RegisterResponse(String token) {
}
