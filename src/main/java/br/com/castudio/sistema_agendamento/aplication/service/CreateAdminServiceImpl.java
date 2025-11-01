package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminResponseDto;
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
    public CreateAdminResponseDto createAdmin(CreateAdminRequestDto requestDto) {
        adminService.validateEmail(requestDto.getEmail());
        adminService.inputPasswordIsMatch(requestDto);
        keyService.isMatch(requestDto.getAdminKey());

        Admin admin = CreateAdminMapper.toEntity(requestDto);
        Admin savedAdmin = adminService.insertAdminInBd(admin);
        return CreateAdminMapper.toResponse(savedAdmin);
    }
}
