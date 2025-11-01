package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminResponseDto;

public interface CreateAdminService {

    public CreateAdminResponseDto createAdmin(CreateAdminRequestDto requestDto);

}
