package br.com.castudio.sistema_agendamento.infra.adapter.in.web.controllers.key;

import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.key.KeyRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.message.MessageResponse;
import br.com.castudio.sistema_agendamento.aplication.domainservice.key.AdminKeyService;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.mapper.ControllerMapper;
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

    private final AdminKeyService adminKeyService;

    @PutMapping
    public ResponseEntity<MessageResponse<Object>> changeKey(
            @Valid @RequestBody KeyRequest keyRequest, @AuthenticationPrincipal UserDetails userDetails
            ){

        adminKeyService.
        String msg = "Chave alterada com sucesso!";
        var response = ControllerMapper.toSuccess(msg, null);
        return ResponseEntity.ok(response);

    }
}
