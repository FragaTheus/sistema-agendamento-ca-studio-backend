package br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.manageruser.delete;

import lombok.Builder;

@Builder
public record DeleteUserRequest(String email, String password){
}
