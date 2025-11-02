package br.com.castudio.sistema_agendamento.aplication.service.login;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterResponse;
import br.com.castudio.sistema_agendamento.aplication.mapper.login.LoginMapper;
import br.com.castudio.sistema_agendamento.aplication.service.key.KeyService;
import br.com.castudio.sistema_agendamento.aplication.service.user.UserService;
import br.com.castudio.sistema_agendamento.configs.security.details.AdminDetails;
import br.com.castudio.sistema_agendamento.configs.security.jwt.JwtService;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final UserService userService;
    private final KeyService keyService;
    private final BCryptPasswordEncoder encoder;
    private final JwtService jwtService;

    @Override
    public RegisterResponse createAdmin(RegisterRequest requestDto) {
        userService.validateEmail(requestDto.getEmail());
        userService.confirmPassword(requestDto);
        keyService.keyIsMatch(requestDto.getAdminKey());
        String hashedPassword = encoder.encode(requestDto.getConfirmPassword());

        Admin admin = LoginMapper.toEntity(requestDto, hashedPassword);
        Admin savedAdmin = userService.saveAdmin(admin);
        var adminDetail = new AdminDetails(savedAdmin);
        String token = jwtService.gererateToken(adminDetail);
        return new RegisterResponse(token);
    }
}
