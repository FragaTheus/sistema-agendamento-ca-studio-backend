package br.com.castudio.sistema_agendamento.aplication.domainservice.user.implementation;

import br.com.castudio.sistema_agendamento.aplication.domainservice.user.contract.UserService;
import br.com.castudio.sistema_agendamento.domain.exceptions.EmailRegisteredException;
import br.com.castudio.sistema_agendamento.domain.exceptions.PasswordsDontMatchException;
import br.com.castudio.sistema_agendamento.domain.exceptions.SameNameException;
import br.com.castudio.sistema_agendamento.domain.entity.user.User;
import br.com.castudio.sistema_agendamento.domain.exceptions.SamePasswordException;
import br.com.castudio.sistema_agendamento.domain.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void confirmInputPasswordIsMatch(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)){
            throw new PasswordsDontMatchException();
        }
    }

    @Override
    public void validatePassword(String password, User user) {
        boolean isMatch = encoder.matches(password, user.getPassword());
        if(!isMatch){
            throw new PasswordsDontMatchException();
        }
    }

    @Override
    public void changeName(String name, User user) {
        if (name.equals(user.getName())){
            throw new SameNameException();
        }
        user.setName(name);
    }

    @Override
    public void changePassword(String password, User user) {
        boolean isMatch = encoder.matches(password, user.getPassword());
        if (isMatch){
            throw new SamePasswordException();
        }
        String hashedPassword = encoder.encode(password);
        user.setPassword(hashedPassword);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }

}
