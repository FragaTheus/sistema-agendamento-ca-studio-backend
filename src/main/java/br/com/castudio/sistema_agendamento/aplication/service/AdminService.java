package br.com.castudio.sistema_agendamento.aplication.service;

import br.com.castudio.sistema_agendamento.aplication.dto.CreateAccountRequest;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;

public interface AdminService {

    public Admin saveAdmin(Admin admin);

    public void validateEmail(String email);

    public void confirmPassword(CreateAccountRequest requestDto);

}
