package br.com.castudio.sistema_agendamento.infra.controllers.key;

import br.com.castudio.sistema_agendamento.aplication.dto.key.KeyRequest;
import br.com.castudio.sistema_agendamento.aplication.dto.message.MessageResponse;
import br.com.castudio.sistema_agendamento.aplication.service.key.KeyService;
import br.com.castudio.sistema_agendamento.infra.configs.security.details.UserDetails;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("api/v1/keys")
@RequiredArgsConstructor
public class KeyController {

    private final KeyService keyService;

    @PutMapping
    public ResponseEntity<MessageResponse<Void>> changeKey(
            @Valid @RequestBody KeyRequest keyRequest, @AuthenticationPrincipal UserDetails userDetails
            ){
        keyService.setKey(keyRequest);
        String msg = "Chave alterada com sucesso!";
        var response = MessageResponse.<Void>sucessWithoutData(msg);
        return ResponseEntity.ok(response);
    }
}
