package br.com.castudio.sistema_agendamento.controllers.user;

import br.com.castudio.sistema_agendamento.aplication.dto.message.MessageResponse;
import br.com.castudio.sistema_agendamento.aplication.dto.update.UpdateRequest;
import br.com.castudio.sistema_agendamento.aplication.service.update.UpdateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user-accounts")
public class UserController {

    private final UpdateService updateService;

    @PatchMapping
    ResponseEntity<MessageResponse<Void>> updateAdmin(@Valid @RequestBody UpdateRequest request){
        var response = MessageResponse.<Void>errorWithoutData("");
        return ResponseEntity.ok(response);
    }

}
