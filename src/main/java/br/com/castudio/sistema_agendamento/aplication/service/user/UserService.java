package br.com.castudio.sistema_agendamento.aplication.service.user;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.domain.entity.User;

public interface UserService {

    public User saveUser(User user);

    public void validateEmail(String email);

    public void confirmPassword(RegisterRequest requestDto);

    public void changePassword(String password);

}
