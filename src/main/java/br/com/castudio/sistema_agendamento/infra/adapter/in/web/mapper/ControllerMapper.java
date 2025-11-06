package br.com.castudio.sistema_agendamento.infra.adapter.in.web.mapper;

import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.login.command.LoginCommand;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.profile.command.UpdateProfileCommand;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.recovery.command.RecoveryCommand;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.register.command.RegisterCommand;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.domainservice.key.command.ChangeKeyCommand;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.profile.command.DeleteProfileCommand;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.delete.DeleteRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.login.LoginRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.profile.ProfileRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.recovery.RecoveryRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.register.RegisterRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.key.ChangeKeyRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.response.MessageResponse;


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

    public static DeleteProfileCommand fromDeleteRequest(DeleteRequest request) {
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
