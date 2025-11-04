package br.com.castudio.sistema_agendamento.aplication.service.profile;

import br.com.castudio.sistema_agendamento.aplication.dto.profile.ProfileRequest;
import br.com.castudio.sistema_agendamento.domain.entity.User;

public interface UserProfileService {

    public User updateProfile(ProfileRequest request, String email);

}
