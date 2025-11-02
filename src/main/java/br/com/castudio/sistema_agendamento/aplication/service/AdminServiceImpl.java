package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAccountRequest;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;
import br.com.castudio.sistema_agendamento.domain.exceptions.DataBaseException;
import br.com.castudio.sistema_agendamento.domain.exceptions.EmailAlreadyExistException;
import br.com.castudio.sistema_agendamento.domain.exceptions.PasswordDontMathcException;
import br.com.castudio.sistema_agendamento.domain.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final AdminRepository repository;

    @Override
    public Admin saveAdmin(Admin admin) {
        try{
            return repository.save(admin);
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
    public void confirmPassword(CreateAccountRequest requestDto) {
        if (!requestDto.getPassword().equals(requestDto.getConfirmPassword())){
            throw new PasswordDontMathcException();
        }
    }




}
