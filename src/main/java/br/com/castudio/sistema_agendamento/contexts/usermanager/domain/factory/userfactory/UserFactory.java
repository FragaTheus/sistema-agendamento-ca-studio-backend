package br.com.castudio.sistema_agendamento.contexts.usermanager.domain.factory.userfactory;

import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.register.command.RegisterCommand;
import br.com.castudio.sistema_agendamento.contexts.usermanager.domain.entity.user.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public record UserFactory() {

    public static User createFromRegisterCommand(RegisterCommand command, BCryptPasswordEncoder encoder){
        String hashedPassword = encoder.encode(command.confirmPassword());
        return new User(command.username(), command.useremail(), hashedPassword);
    }

}
