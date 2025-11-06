package br.com.castudio.sistema_agendamento.aplication.aplicationservices.profile.implementation;

import br.com.castudio.sistema_agendamento.aplication.aplicationservices.profile.command.UpdateProfileCommand;
import br.com.castudio.sistema_agendamento.aplication.aplicationservices.profile.contract.UserProfileService;
import br.com.castudio.sistema_agendamento.aplication.aplicationservices.profile.command.DeleteProfileCommand;
import br.com.castudio.sistema_agendamento.aplication.domainservice.user.contract.UserService;
import br.com.castudio.sistema_agendamento.domain.entity.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserService userService;

    @Override
    public User updateProfile(UpdateProfileCommand command) {

        User user = userService.findUserByEmail(command.email());
        userService.validatePassword(command.currentPassword(), user);

        if (command.name() != null && !command.name().isBlank()){
            userService.changeName(command.name(), user);
        }

        if (command.newPassword() != null && !command.newPassword().isBlank()){
            userService.changePassword(command.newPassword(), user);
        }

        return userService.saveUser(user);
    }

    @Override
    public void deleteProfile(DeleteProfileCommand command) {
        User user = userService.findUserByEmail(command.email());
        userService.validatePassword(command.password(), user);
        userService.deleteUser(user);
    }

}
