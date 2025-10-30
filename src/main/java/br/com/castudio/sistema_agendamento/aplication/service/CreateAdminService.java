package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminResponseDto;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;

public interface CreateAdminService {

    public Admin saveAdmin(Admin admin);

    public boolean verifyEmail(String email);

    public boolean verifyPassword(CreateAdminRequestDto requestDto);

    public CreateAdminResponseDto createAdmin(CreateAdminRequestDto requestDto);


}
