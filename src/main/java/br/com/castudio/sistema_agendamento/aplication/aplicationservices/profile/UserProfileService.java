package br.com.castudio.sistema_agendamento.aplication.aplicationservices.profile;

import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.profile.ProfileRequest;
import br.com.castudio.sistema_agendamento.domain.entity.User;

public interface UserProfileService {

    public User updateProfile(ProfileRequest request, String email);

}
