package br.com.castudio.sistema_agendamento.domain.repository;

import br.com.castudio.sistema_agendamento.domain.entity.Admin;

public interface AdminReposioty {

    public Admin saveAdmin(Admin admin);

    public String findAdminEmail(String adminEmail);

}
