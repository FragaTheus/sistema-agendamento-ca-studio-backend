package br.com.castudio.sistema_agendamento.infra.adapter.in.web.controllers.user;

import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.profile.command.UpdateProfileCommand;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.profile.command.DeleteProfileCommand;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.delete.DeleteRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.response.MessageResponse;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.profile.ProfileRequest;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.aplicationservices.profile.contract.UserProfileService;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.mapper.ControllerMapper;
import br.com.castudio.sistema_agendamento.infra.configs.security.userdetails.UserDetails;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user-accounts")
public class UserController {

    private final UserProfileService userProfileService;

    @PatchMapping
    ResponseEntity<MessageResponse<Object>> updateAdmin(
            @Valid @RequestBody ProfileRequest request, @AuthenticationPrincipal UserDetails userDetails
    ){
        UpdateProfileCommand command = ControllerMapper.fromUpdateProfileRequest(request, userDetails.getUsername());
        userProfileService.updateProfile(command);
        String msg = "Dados atualizados com sucesso!";
        var response = ControllerMapper.toSuccess(msg, null);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(response);
    }

    @DeleteMapping
    ResponseEntity<MessageResponse<Object>> deleteAdmin(
            @Valid @RequestBody DeleteRequest request, @AuthenticationPrincipal UserDetails userDetails
    ){
        DeleteProfileCommand command = ControllerMapper.fromDeleteRequest(request);
        userProfileService.deleteProfile(command);
        String msg = "Conta deletada com sucesso!";
        var response = ControllerMapper.toSuccess(msg, null);
        return ResponseEntity.ok(response);
    }

}
