package br.com.castudio.sistema_agendamento.aplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AuthenticationResponse {

    private final String token;

}
