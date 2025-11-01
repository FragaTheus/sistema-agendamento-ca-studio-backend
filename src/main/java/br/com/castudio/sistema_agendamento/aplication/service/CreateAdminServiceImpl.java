package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAccountRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAccountResponse;
import br.com.castudio.sistema_agendamento.aplication.mapper.CreateAdminMapper;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAdminServiceImpl implements CreateAdminService{

    private final AdminService adminService;
    private final KeyService keyService;

    @Override
    public CreateAccountResponse createAdmin(CreateAccountRequest requestDto) {
        adminService.validateEmail(requestDto.getEmail());
        adminService.confirmPassword(requestDto);
        keyService.keyIsMatch(requestDto.getAdminKey());

        Admin admin = CreateAdminMapper.toEntity(requestDto);
        Admin savedAdmin = adminService.saveAdmin(admin);
        return CreateAdminMapper.toResponse(savedAdmin);
    }
}
