package br.com.castudio.sistema_agendamento.aplication.service.authentication;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.login.LoginRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.login.LoginResponse;

public interface AuthenticationService {


    public LoginResponse authenticate(LoginRequest request);

}
