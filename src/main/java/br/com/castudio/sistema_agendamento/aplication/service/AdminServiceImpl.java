package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminResponseDto;
import br.com.castudio.sistema_agendamento.aplication.mapper.CreateAdminMapper;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;
import br.com.castudio.sistema_agendamento.domain.exceptions.admin.EmailAlreadyExistException;
import br.com.castudio.sistema_agendamento.domain.exceptions.admin.PasswordDontMathcException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class AdminServiceImpl implements AdminService {

    //Simula Base
    private ArrayList<Admin> repository = new ArrayList<>();

    @Override
    public Admin saveAdmin(Admin admin) {
        repository.add(admin);
        return admin;
    }

    @Override
    public boolean verifyEmail(String email) {
        return repository.stream().anyMatch(admin1 -> admin1.getEmail().value().equals(email));
    }

    @Override
    public boolean verifyPassword(CreateAdminRequestDto requestDto) {
        String password = requestDto.getPassword();
        String confirmPassword = requestDto.getConfirmPassword();
        boolean isEqual = password.equals(confirmPassword);
        return isEqual;
    }

    @Override
    public CreateAdminResponseDto createAdmin(CreateAdminRequestDto requestDto) {

        if (verifyEmail(requestDto.getEmail())){
            throw new EmailAlreadyExistException(requestDto.getEmail());
        }

        if (!verifyPassword(requestDto)){
            throw new PasswordDontMathcException();
        }

        CreateAdminMapper mapper = new CreateAdminMapper();
        Admin admin = mapper.toEntity(requestDto);

        repository.add(admin);
        CreateAdminResponseDto responseDto = mapper.toResponse(admin);
        return responseDto;
    }
}
