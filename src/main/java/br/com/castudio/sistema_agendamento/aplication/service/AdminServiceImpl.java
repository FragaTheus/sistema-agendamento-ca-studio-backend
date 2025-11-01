package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
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
    public Admin insertAdminInBd(Admin admin) {
        try{
            return repository.saveAdmin(admin);
        }catch (Exception e){
            throw new DataBaseException();
        }
    }

    @Override
    public boolean validateEmail(String email) {
            boolean isExist = repository.emailExists(email);
            if (isExist){
                throw new EmailAlreadyExistException(email);
            }
            return isExist;
    }

    @Override
    public void inputPasswordIsMatch(CreateAdminRequestDto requestDto) {
        boolean isMatch = requestDto.getPassword().equals(requestDto.getConfirmPassword());
        if (!isMatch){
            throw new PasswordDontMathcException();
        }
    }
}
