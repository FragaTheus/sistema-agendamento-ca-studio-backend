package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAccountRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAccountResponse;

public interface CreateAdminService {

    public CreateAccountResponse createAdmin(CreateAccountRequest requestDto);

}
