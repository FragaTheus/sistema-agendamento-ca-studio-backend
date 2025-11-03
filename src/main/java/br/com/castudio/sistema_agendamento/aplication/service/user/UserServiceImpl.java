package br.com.castudio.sistema_agendamento.aplication.service.user;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.domain.entity.User;
import br.com.castudio.sistema_agendamento.domain.exceptions.DataBaseException;
import br.com.castudio.sistema_agendamento.domain.exceptions.EmailAlreadyExistException;
import br.com.castudio.sistema_agendamento.domain.exceptions.PasswordDontMathcException;
import br.com.castudio.sistema_agendamento.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User saveUser(User user) {
        try{
            return repository.save(user);
        }catch (Exception e){
            throw new DataBaseException();
        }
    }

    @Override
    public void validateEmail(String email) {
            boolean isExist = repository.existsByEmail(email);
            if (isExist){
                throw new EmailAlreadyExistException(email);
            }
    }

    @Override
    public void confirmPassword(RegisterRequest requestDto) {
        if (!requestDto.getPassword().equals(requestDto.getConfirmPassword())){
            throw new PasswordDontMathcException();
        }
    }

    @Override
    public void changePassword(String password) {

    }

}
