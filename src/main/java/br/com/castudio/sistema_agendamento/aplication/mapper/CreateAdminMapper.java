package br.com.castudio.sistema_agendamento.aplication.mapper;


import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminRequestDto;
import br.com.castudio.sistema_agendamento.aplication.dto.CreateAdminResponseDto;
import br.com.castudio.sistema_agendamento.domain.entity.Admin;


public record CreateAdminMapper() {

    public Admin toEntity(CreateAdminRequestDto requestDto){
        return new Admin(requestDto.getName(), requestDto.getEmail(), requestDto.getConfirmPassword());
    }

    public CreateAdminResponseDto toResponse(Admin admin){
        return new CreateAdminResponseDto(admin.getUuid(), admin.getName(), admin.getEmail().value());
    }

}
