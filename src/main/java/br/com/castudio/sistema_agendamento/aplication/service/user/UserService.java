package br.com.castudio.sistema_agendamento.aplication.service.user;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.domain.entity.User;

import java.util.Optional;

public interface UserService {

    public User saveUser(User user);

    public void ensureEmailNotRegistered(String email);

    public User ensureUserExists(String email);

    public void confirmPassword(RegisterRequest requestDto);

    public boolean passwordIsMatch(String password, User user);

    public void changePassword(String newPassword, User user);

    public String encodePassword(String password);

    public void changeName(String name, User user);

}
