package br.com.castudio.sistema_agendamento.aplication.service.user;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.domain.entity.User;

import java.util.Optional;

public interface UserService {

    public User saveUser(User user);

    public void ensureEmailNotRegistered(String email);

    public User ensureUserExists(String email);

    public void confirmPassword(RegisterRequest requestDto);

    public void changePassword(String currentPassword, String newPassword);

    public String encodePassword(String password);

}
