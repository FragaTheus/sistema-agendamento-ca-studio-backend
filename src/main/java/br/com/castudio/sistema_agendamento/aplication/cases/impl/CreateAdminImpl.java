package br.com.castudio.sistema_agendamento.aplication.cases.impl;

import br.com.castudio.sistema_agendamento.aplication.cases.interfaces.CreateAdminCase;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminResponseDto;
import br.com.castudio.sistema_agendamento.aplication.mapper.CreateAdminMapper;
import br.com.castudio.sistema_agendamento.aplication.service.interfaces.AdminKeyService;
import br.com.castudio.sistema_agendamento.aplication.service.interfaces.AdminService;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;
import br.com.castudio.sistema_agendamento.domain.exceptions.admin.EmailAlreadyExistException;
import br.com.castudio.sistema_agendamento.domain.exceptions.admin.PasswordDontMathcException;
import br.com.castudio.sistema_agendamento.domain.exceptions.adminKey.WrongAdminKeyException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAdminImpl implements CreateAdminCase {

    private AdminService adminService;
    private AdminKeyService keyService;

    @Override
    public CreateAdminResponseDto createAdmin(CreateAdminRequestDto requestDto) {

        boolean isRegistered = adminService.verifyEmail(requestDto.getEmail());
        if (isRegistered){
            throw new EmailAlreadyExistException(requestDto.getEmail());
        }

        boolean isMatchAdminPasswords = adminService.verifyPassword(requestDto);
        if (!isMatchAdminPasswords){
            throw new PasswordDontMathcException();
        }

        boolean isMatchAdminKey = keyService.verifyAdminKey(requestDto.getAdminKey());
        if (!isMatchAdminKey){
            throw new WrongAdminKeyException();
        }

        CreateAdminMapper mapper = new CreateAdminMapper();
        Admin admin = mapper.toEntity(requestDto);
        Admin savedAdmin = adminService.saveAdmin(admin);
        return mapper.toResponse(savedAdmin);

    }
}
