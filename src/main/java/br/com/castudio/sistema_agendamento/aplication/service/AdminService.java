package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;

public interface AdminService {

    public Admin insertAdminInBd(Admin admin);

    public boolean validateEmail(String email);

    public void inputPasswordIsMatch(CreateAdminRequestDto requestDto);

}
