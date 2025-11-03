package br.com.castudio.sistema_agendamento.controllers.user;

import br.com.castudio.sistema_agendamento.aplication.dto.message.MessageResponse;
import br.com.castudio.sistema_agendamento.aplication.dto.profile.ProfileRequest;
import br.com.castudio.sistema_agendamento.aplication.service.profile.UserProfileService;
import br.com.castudio.sistema_agendamento.configs.security.details.UserDetails;
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
    ResponseEntity<MessageResponse<Void>> updateAdmin(
            @Valid @RequestBody ProfileRequest request, @AuthenticationPrincipal UserDetails userDetails
    ){
        userProfileService.updateProfile(request, userDetails.getUsername());
        String msg = "Dados atualizados com sucesso!";
        var response = MessageResponse.<Void>sucessWithoutData(msg);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(response);
    }

}
