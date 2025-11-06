package br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.response;

import lombok.Builder;

@Builder
public record MessageResponse<T>(boolean sucess, String msg, T data){

}
