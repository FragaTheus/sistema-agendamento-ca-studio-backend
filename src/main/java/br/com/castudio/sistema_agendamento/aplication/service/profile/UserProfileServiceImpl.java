package br.com.castudio.sistema_agendamento.aplication.service.profile;

import br.com.castudio.sistema_agendamento.aplication.dto.profile.ProfileRequest;
import br.com.castudio.sistema_agendamento.aplication.service.user.UserService;
import br.com.castudio.sistema_agendamento.domain.entity.User;
import br.com.castudio.sistema_agendamento.domain.exceptions.business.PasswordsDontMatchException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserProfileServiceImpl implements UserProfileService{

    private final UserService userService;

    @Override
    public User updateProfile(ProfileRequest request, String email) {

        User user = userService.ensureUserExists(email);

        if (request.getName() != null &&  !request.getName().isBlank()){
            userService.changeName(request.getName(), user);
        }

        if (request.getNewPassword() != null && !request.getNewPassword().isBlank()){
            if (!userService.passwordIsMatch(request.getCurrentPassword(), user)){
                throw new PasswordsDontMatchException();
            }
            String hashedPassword = userService.encodePassword(request.getNewPassword());
            userService.changePassword(hashedPassword, user);
        }
        return userService.saveUser(user);
    }

}
