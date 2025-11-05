package br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.login;

import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.login.LoginRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.login.LoginResponse;

public interface LoginService {


    public LoginResponse authenticate(LoginRequest request);

}
