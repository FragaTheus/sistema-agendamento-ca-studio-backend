package br.com.castudio.sistema_agendamento.aplication.service.authentication.register;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterResponse;

public interface RegisterService {

    public RegisterResponse createAdmin(RegisterRequest request);

}
