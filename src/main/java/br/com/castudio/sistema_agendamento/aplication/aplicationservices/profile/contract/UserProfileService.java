package br.com.castudio.sistema_agendamento.aplication.aplicationservices.profile.contract;

import br.com.castudio.sistema_agendamento.aplication.aplicationservices.profile.command.UpdateProfileCommand;
import br.com.castudio.sistema_agendamento.aplication.aplicationservices.profile.command.DeleteProfileCommand;
import br.com.castudio.sistema_agendamento.domain.entity.user.User;

public interface UserProfileService {

    public User updateProfile(UpdateProfileCommand command);

    void deleteProfile(DeleteProfileCommand command);
}
