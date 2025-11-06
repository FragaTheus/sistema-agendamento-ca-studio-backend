package br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.profile.contract;

import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.profile.command.UpdateProfileCommand;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.profile.command.DeleteProfileCommand;
import br.com.castudio.sistema_agendamento.contexts.usermanager.domain.entity.user.User;

public interface UserProfileService {

    public User updateProfile(UpdateProfileCommand command);

    void deleteProfile(DeleteProfileCommand command);
}
