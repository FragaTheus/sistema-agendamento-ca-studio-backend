package br.com.castudio.sistema_agendamento.aplication.dto;


import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateAccountResponse(String token) {
}
