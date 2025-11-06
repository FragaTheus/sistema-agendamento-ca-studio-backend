package br.com.castudio.sistema_agendamento.infra.adapter.in.web.controllers.manageruser.key;

import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.domainservice.key.command.ChangeKeyCommand;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.manageruser.key.ChangeKeyRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.response.MessageResponse;
import br.com.castudio.sistema_agendamento.contexts.usermanager.aplication.domainservice.key.contract.AdminKeyService;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.mapper.ControllerMapper;
import br.com.castudio.sistema_agendamento.infra.configs.security.userdetails.UserDetails;
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
public class AdminKeyController {

    private final AdminKeyService adminKeyService;

    @PutMapping
    public ResponseEntity<MessageResponse<Object>> changeKey(
            @Valid @RequestBody ChangeKeyRequest keyRequest, @AuthenticationPrincipal UserDetails userDetails
            ){

        ChangeKeyCommand command = ControllerMapper.fromChangeKeyRequest(keyRequest);
        adminKeyService.changeAdminKey(command);
        String msg = "Chave alterada com sucesso!";
        var response = ControllerMapper.toSuccess(msg, null);
        return ResponseEntity.ok(response);

    }
}
