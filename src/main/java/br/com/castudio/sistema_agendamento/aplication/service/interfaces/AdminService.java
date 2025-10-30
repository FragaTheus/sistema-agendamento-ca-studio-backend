package br.com.castudio.sistema_agendamento.aplication.service.interfaces;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;

public interface AdminService {

    public Admin saveAdmin(Admin admin);

    public boolean verifyEmail(String email);

    public boolean verifyPassword(CreateAdminRequestDto requestDto);

}
