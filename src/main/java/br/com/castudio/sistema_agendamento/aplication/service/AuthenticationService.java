package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.aplication.dto.AuthenticationRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.AuthenticationResponse;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAccountRequest;

public interface AuthenticationService {


    public AuthenticationResponse authenticate(AuthenticationRequest request);

}
