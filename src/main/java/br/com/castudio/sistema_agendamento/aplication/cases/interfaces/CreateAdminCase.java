package br.com.castudio.sistema_agendamento.aplication.cases.interfaces;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminResponseDto;

public interface CreateAdminCase {

    public CreateAdminResponseDto createAdmin(CreateAdminRequestDto requestDto);

}
