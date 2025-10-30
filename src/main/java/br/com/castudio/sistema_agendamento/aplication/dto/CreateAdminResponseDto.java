package br.com.castudio.sistema_agendamento.aplication.dto;


import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
public record CreateAdminResponseDto(UUID uuid, String name, String email) {
}
