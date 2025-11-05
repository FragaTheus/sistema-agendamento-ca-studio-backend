package br.com.castudio.sistema_agendamento.aplication.service.user;

import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.domain.entity.User;

public interface UserService {

    public User saveUser(User user);

    public boolean existsUserByEmail(String email);

    public void confirmInputPasswordIsMatch(String password, String confirmPassword);

    public void validatePassword(String password, User user);

    public void changePassword(String newPassword, User user);

    public void changeName(String name, User user);

}
