package br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.login;

import br.com.castudio.sistema_agendamento.domain.entity.User;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.login.LoginRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.login.LoginResponse;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginService {


    public String authenticate(LoginCommand command);

}
