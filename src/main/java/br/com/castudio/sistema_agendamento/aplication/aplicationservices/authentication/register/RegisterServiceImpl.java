package br.com.castudio.sistema_agendamento.aplication.aplicationservices.authentication.register;

import br.com.castudio.sistema_agendamento.domain.entity.AdminKey;
import br.com.castudio.sistema_agendamento.aplication.domainservice.key.AdminKeyService;
import br.com.castudio.sistema_agendamento.aplication.domainservice.user.UserService;
import br.com.castudio.sistema_agendamento.infra.configs.security.details.UserDetails;
import br.com.castudio.sistema_agendamento.infra.configs.security.jwt.JwtService;
import br.com.castudio.sistema_agendamento.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserService userService;
    private final AdminKeyService adminKeyService;
    private final JwtService jwtService;

    @Override
    public String registerUser(RegisterCommand command) {

        userService.existsUserByEmail(command.useremail());
        userService.confirmInputPasswordIsMatch(command.userPassword(), command.confirmPassword());
        userService.encodePassword(command.confirmPassword());
        AdminKey databaseAdminKey = adminKeyService.findKeyById();
        adminKeyService.keyIsMatch(command.adminKey(), databaseAdminKey.getValue());
        User user = RegisterMapper.fromCommand(command);
        User savedUser = userService.saveUser(user);
        UserDetails userDetails = new UserDetails(savedUser);
        return jwtService.gererateToken(userDetails);

    }
}
