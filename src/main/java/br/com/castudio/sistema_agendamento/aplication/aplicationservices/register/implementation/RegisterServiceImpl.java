package br.com.castudio.sistema_agendamento.aplication.aplicationservices.register.implementation;

import br.com.castudio.sistema_agendamento.aplication.aplicationservices.register.command.RegisterCommand;
import br.com.castudio.sistema_agendamento.aplication.aplicationservices.register.contract.RegisterService;
import br.com.castudio.sistema_agendamento.aplication.domainservice.key.contract.AdminKeyService;
import br.com.castudio.sistema_agendamento.aplication.domainservice.user.contract.UserService;
import br.com.castudio.sistema_agendamento.domain.factory.userfactory.UserFactory;
import br.com.castudio.sistema_agendamento.infra.configs.security.userdetails.UserDetails;
import br.com.castudio.sistema_agendamento.infra.configs.security.jwt.JwtService;
import br.com.castudio.sistema_agendamento.domain.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserService userService;
    private final AdminKeyService adminKeyService;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder encoder;

    @Override
    public String registerUser(RegisterCommand command) {

        userService.existsUserByEmail(command.useremail());
        userService.confirmInputPasswordIsMatch(command.userPassword(), command.confirmPassword());
        adminKeyService.validateKey(command.adminKey());
        User user = UserFactory.createFromRegisterCommand(command, encoder);
        User savedUser = userService.saveUser(user);
        UserDetails userDetails = new UserDetails(savedUser);
        return jwtService.gererateToken(userDetails);

    }
}
