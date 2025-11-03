package br.com.castudio.sistema_agendamento.aplication.service.authentication.login;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.login.LoginRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.login.LoginResponse;

public interface LoginService {


    public LoginResponse authenticate(LoginRequest request);

}
