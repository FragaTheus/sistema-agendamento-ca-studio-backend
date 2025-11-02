package br.com.castudio.sistema_agendamento.aplication.mapper;


import br.com.castudio.sistema_agendamento.aplication.dto.CreateAccountRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAccountResponse;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;


public class CreateAdminMapper {

    public static Admin toEntity(CreateAccountRequest requestDto, String hashedPassword){
        return Admin.builder()
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(hashedPassword)
                .build();
    }

    public static CreateAccountResponse toResponse(Admin admin){
        return new CreateAccountResponse(admin.getId(), admin.getName(), admin.getEmail());
    }

}
