package br.com.castudio.sistema_agendamento.infra.adapter.in.web.mapper;

import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.command.CreateProcedureCommand;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.command.DeleteProcedureCommand;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.entity.Procedure;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.login.command.LoginCommand;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.profile.command.UpdateProfileCommand;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.recovery.command.RecoveryCommand;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.register.command.RegisterCommand;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.domainservice.key.command.ChangeKeyCommand;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.profile.command.DeleteProfileCommand;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.managerprocedure.delete.DeleteProcedureRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.manageruser.delete.DeleteUserRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.manageruser.login.LoginRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.managerprocedure.create.CreateProcedureRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.manageruser.profile.ProfileRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.manageruser.recovery.RecoveryRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.manageruser.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.manageruser.key.ChangeKeyRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.response.MessageResponse;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.managerprocedure.response.ProcedureResponse;

import java.util.ArrayList;
import java.util.List;


public record ControllerMapper() {

    public static RegisterCommand fromRegisterRequest(RegisterRequest request){
        return RegisterCommand.builder()
                .username(request.getName())
                .useremail(request.getEmail())
                .userPassword(request.getPassword())
                .confirmPassword(request.getConfirmPassword())
                .adminKey(request.getAdminKey())
                .build();
    }

    public static LoginCommand fromLoginRequest(LoginRequest request){
        return LoginCommand.builder()
                .useremail(request.getEmail())
                .userPassword(request.getPassword())
                .build();
    }

    public static DeleteProfileCommand fromUserDeleteReques(DeleteUserRequest request) {
        return DeleteProfileCommand.builder()
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static RecoveryCommand fromRecoveryRequest(RecoveryRequest request){
        return RecoveryCommand.builder()
                .userEmail(request.getEmail())
                .newPassword(request.getNewPassword())
                .build();
    }

    public static UpdateProfileCommand fromUpdateProfileRequest(ProfileRequest request, String email){
        return UpdateProfileCommand.builder()
                .email(email)
                .name(request.getName())
                .currentPassword(request.getCurrentPassword())
                .newPassword(request.getNewPassword())
                .build();
    }

    public static ChangeKeyCommand fromChangeKeyRequest(ChangeKeyRequest request){
        return ChangeKeyCommand.builder()
                .currentKey(request.currentKey())
                .newKey(request.newKey())
                .build();
    }

    public static List<ProcedureResponse> fromProcedureEntity(List<Procedure> procedures){
        List<ProcedureResponse> responseList = new ArrayList<>();
        for (Procedure procedure : procedures){
            responseList.add(
                    ProcedureResponse.builder()
                            .id(procedure.getId())
                            .name(procedure.getName())
                            .duration(procedure.getDuration())
                            .build()
            );
        }
        return responseList;
    }

    public static CreateProcedureCommand fromCreateProcedureRequest(CreateProcedureRequest request){
        return CreateProcedureCommand.builder()
                .name(request.getName())
                .description(request.getDescription())
                .category(request.getCategory())
                .price(request.getPrice())
                .duration(request.getDuration())
                .build();
    }

    public static DeleteProcedureCommand fromDeleteProcedureRequest(DeleteProcedureRequest request){
        return DeleteProcedureCommand.builder()
                .adminKey(request.getAdminKey())
                .build();
    }

    public static <T> MessageResponse<T> toSuccess(String msg, T data) {
        return MessageResponse.<T>builder()
                .sucess(true)
                .msg(msg)
                .data(data)
                .build();
    }

    public static <T> MessageResponse<T> toError(String msg, T data) {
        return MessageResponse.<T>builder()
                .sucess(false)
                .msg(msg)
                .data(data)
                .build();
    }


}
