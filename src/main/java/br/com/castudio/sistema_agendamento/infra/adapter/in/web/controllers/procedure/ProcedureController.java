package br.com.castudio.sistema_agendamento.infra.adapter.in.web.controllers.procedure;


import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.procedure.command.CreateProcedureCommand;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.aplication.procedure.contract.ProcedureService;
import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.entity.Procedure;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.request.procedure.CreateProcedureRequest;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.response.MessageResponse;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.response.ProcedureResponse;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.mapper.ControllerMapper;
import br.com.castudio.sistema_agendamento.infra.configs.security.userdetails.UserDetails;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/procedures")
@RequiredArgsConstructor
public class ProcedureController {

    private final ProcedureService procedureService;

    @PostMapping
    public ResponseEntity<MessageResponse<Object>> createProcedure(
            @Valid @RequestBody CreateProcedureRequest request,
            @AuthenticationPrincipal UserDetails userDetails
            ){
        CreateProcedureCommand command = ControllerMapper.fromCreateProcedureRequest(request);
        procedureService.createProcedure(command);
        String msg = "Procedimento cadastrado com sucesso!";
        MessageResponse<Object> response = ControllerMapper.toSuccess(msg, null);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProcedureResponse>> getAll(){
        List<Procedure> procedures = procedureService.findActiveProcedures();
        List<ProcedureResponse> response = ControllerMapper.fromProcedureEntity(procedures);
        return ResponseEntity.ok(response);
    }

}
