package br.com.castudio.sistema_agendamento.aplication.service.authentication.register;

import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.authentication.register.RegisterResponse;
import br.com.castudio.sistema_agendamento.aplication.service.key.KeyService;
import br.com.castudio.sistema_agendamento.aplication.service.user.UserService;
import br.com.castudio.sistema_agendamento.infra.configs.security.details.UserDetails;
import br.com.castudio.sistema_agendamento.infra.configs.security.jwt.JwtService;
import br.com.castudio.sistema_agendamento.domain.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserService userService;
    private final KeyService keyService;
    private final JwtService jwtService;

    @Override
    public RegisterResponse createAdmin(RegisterRequest request) {
        userService.ensureEmailNotRegistered(request.getEmail());
        userService.confirmPassword(request);
        keyService.keyIsMatch(request.getAdminKey());
        String hashedPassword = userService.encodePassword(request.getConfirmPassword());

        User user = new User(request.getName(), request.getEmail(), hashedPassword);

        User savedUser = userService.saveUser(user);
        UserDetails userDetails = new UserDetails(savedUser);
        String token = jwtService.gererateToken(userDetails);
        return new RegisterResponse(token);
    }
}
