package br.com.castudio.sistema_agendamento.aplication.service.login;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterResponse;

public interface LoginService {


    public RegisterResponse createAdmin(RegisterRequest requestDto);

}
