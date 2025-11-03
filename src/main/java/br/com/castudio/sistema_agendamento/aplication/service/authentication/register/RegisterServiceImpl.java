package br.com.castudio.sistema_agendamento.aplication.service.authentication.register;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterResponse;
import br.com.castudio.sistema_agendamento.aplication.mapper.login.AdminMapper;
import br.com.castudio.sistema_agendamento.aplication.service.key.KeyService;
import br.com.castudio.sistema_agendamento.aplication.service.user.UserService;
import br.com.castudio.sistema_agendamento.configs.security.details.AdminDetails;
import br.com.castudio.sistema_agendamento.configs.security.jwt.JwtService;
import br.com.castudio.sistema_agendamento.domain.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService {

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

        User user = AdminMapper.registerToEntity(requestDto, hashedPassword);
        User savedUser = userService.saveAdmin(user);
        var adminDetail = new AdminDetails(savedUser);
        String token = jwtService.gererateToken(adminDetail);
        return new RegisterResponse(token);
    }
}
