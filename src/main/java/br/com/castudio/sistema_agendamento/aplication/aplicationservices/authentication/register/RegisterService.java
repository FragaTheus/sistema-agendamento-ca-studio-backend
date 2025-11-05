package br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.register;

import br.com.castudio.sistema_agendamento.domain.entity.User;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.register.RegisterResponse;

public interface RegisterService {

    public String createAdmin(User user, String confirmPassword, String inputAdminKey);

}
