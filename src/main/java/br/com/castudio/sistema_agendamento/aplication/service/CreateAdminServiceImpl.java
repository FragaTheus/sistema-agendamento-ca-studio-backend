package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAccountRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAccountResponse;
import br.com.castudio.sistema_agendamento.aplication.mapper.CreateAdminMapper;
import br.com.castudio.sistema_agendamento.configs.security.details.AdminDetails;
import br.com.castudio.sistema_agendamento.configs.security.jwt.JwtService;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAdminServiceImpl implements CreateAdminService{

    private final AdminService adminService;
    private final KeyService keyService;
    private final BCryptPasswordEncoder encoder;
    private final JwtService jwtService;

    @Override
    public CreateAccountResponse createAdmin(CreateAccountRequest requestDto) {
        adminService.validateEmail(requestDto.getEmail());
        adminService.confirmPassword(requestDto);
        keyService.keyIsMatch(requestDto.getAdminKey());
        String hashedPassword = encoder.encode(requestDto.getConfirmPassword());

        Admin admin = CreateAdminMapper.toEntity(requestDto, hashedPassword);
        Admin savedAdmin = adminService.saveAdmin(admin);
        var adminDetail = new AdminDetails(savedAdmin);
        String token = jwtService.gererateToken(adminDetail);
        return new CreateAccountResponse(token);
    }
}
