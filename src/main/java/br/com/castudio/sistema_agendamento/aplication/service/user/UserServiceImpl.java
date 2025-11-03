package br.com.castudio.sistema_agendamento.aplication.service.user;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.domain.entity.User;
import br.com.castudio.sistema_agendamento.domain.exceptions.business.EmailRegisteredException;
import br.com.castudio.sistema_agendamento.domain.exceptions.business.PasswordsDontMatchException;
import br.com.castudio.sistema_agendamento.domain.exceptions.business.UnregisteredUser;
import br.com.castudio.sistema_agendamento.domain.exceptions.system.DataBaseException;
import br.com.castudio.sistema_agendamento.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder;

    @Override
    public User saveUser(User user) {
        try{
            return repository.save(user);
        }catch (Exception e){
            throw new DataBaseException();
        }
    }

    @Override
    public void ensureEmailNotRegistered(String email) {
            boolean isExist = repository.existsByEmail(email);
            if (isExist){
                throw new EmailRegisteredException();
            }
    }

    @Override
    public User ensureUserExists(String email) {
        return repository.findByEmail(email).orElseThrow(()-> new UnregisteredUser());
    }

    @Override
    public void confirmPassword(RegisterRequest requestDto) {
        if (!requestDto.getPassword().equals(requestDto.getConfirmPassword())){
            throw new PasswordsDontMatchException();
        }
    }

    @Override
    public void changePassword(String currentPassword, String newPassword) {
        //Capturar nova senha
        //Confirmar nova senha com senha na base
        //Hashar nova senha
        //Retornar nova senha
    }

    @Override
    public String encodePassword(String password) {
        return encoder.encode(password);
    }


}
