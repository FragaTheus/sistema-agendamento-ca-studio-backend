package br.com.castudio.sistema_agendamento.aplication.service.user;

import br.com.castudio.sistema_agendamento.domain.exceptions.business.*;
import br.com.castudio.sistema_agendamento.domain.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder encoder;

    @Override
    public void confirmInputPasswordIsMatch(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)){
            throw new PasswordsDontMatchException();
        }
    }

    @Override
    public void validatePassword(String password, User user) {
        if (!encoder.matches(password, user.getPassword())){
            throw new PasswordsDontMatchException();
        }
    }

    @Override
    public void changePassword(String rawPassword, User user) {
        rawPassword = encoder.encode(rawPassword);
        user.setPassword(rawPassword);
    }

    @Override
    public void changeName(String name, User user) {
        if (name.equals(user.getName())){
            throw new SameNameException();
        }
        user.setName(name);
    }

}
