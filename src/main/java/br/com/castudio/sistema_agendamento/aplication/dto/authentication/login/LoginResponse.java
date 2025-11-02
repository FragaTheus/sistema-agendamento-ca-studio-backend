package br.com.castudio.sistema_agendamento.aplication.dto.authentication.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LoginResponse {

    private final String token;

}
