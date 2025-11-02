package br.com.castudio.sistema_agendamento.aplication.service.user;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;

public interface UserService {

    public Admin saveAdmin(Admin admin);

    public void validateEmail(String email);

    public void confirmPassword(RegisterRequest requestDto);

}
