package br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.register;

import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import br.com.castudio.sistema_agendamento.domain.repository.AdminKeyRepository;
import br.com.castudio.sistema_agendamento.domain.repository.UserRepository;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.authentication.register.RegisterResponse;
import br.com.castudio.sistema_agendamento.aplication.service.key.AdminKeyService;
import br.com.castudio.sistema_agendamento.aplication.service.user.UserService;
import br.com.castudio.sistema_agendamento.infra.configs.security.details.UserDetails;
import br.com.castudio.sistema_agendamento.infra.configs.security.jwt.JwtService;
import br.com.castudio.sistema_agendamento.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserService userService;
    private final AdminKeyService adminKeyService;
    private final JwtService jwtService;

    @Override
    public String registerUser(User user, String confirmPassword, String inputAdminKey) {

        userService.existsUserByEmail(user.getEmail());
        userService.confirmInputPasswordIsMatch(user.getPassword(), confirmPassword);
        userService.changePassword(confirmPassword, user);
        AdminKey databaseAdminKey = adminKeyService.findKeyById();
        adminKeyService.keyIsMatch(inputAdminKey, databaseAdminKey.getValue());

        User savedUser = userService.saveUser(user);
        UserDetails userDetails = new UserDetails(savedUser);
        return jwtService.gererateToken(userDetails);

    }
}
