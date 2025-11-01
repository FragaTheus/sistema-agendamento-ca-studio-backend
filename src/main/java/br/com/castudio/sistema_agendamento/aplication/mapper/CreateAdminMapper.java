package br.com.castudio.sistema_agendamento.aplication.mapper;


import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminResponseDto;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;


public class CreateAdminMapper {

    public static Admin toEntity(CreateAdminRequestDto requestDto){
        return new Admin(requestDto.getName(), requestDto.getEmail(), requestDto.getConfirmPassword());
    }

    public static CreateAdminResponseDto toResponse(Admin admin){
        return new CreateAdminResponseDto(admin.getUuid(), admin.getName(), admin.getEmail());
    }

}
