package br.com.castudio.sistema_agendamento.infra.adapter.in.web.controllers.handler;

import br.com.castudio.sistema_agendamento.infra.adapter.in.web.dto.response.MessageResponse;
import br.com.castudio.sistema_agendamento.domain.exceptions.CredentialsException;
import br.com.castudio.sistema_agendamento.domain.exceptions.EmailRegisteredException;
import br.com.castudio.sistema_agendamento.domain.exceptions.PasswordsDontMatchException;
import br.com.castudio.sistema_agendamento.domain.exceptions.WrongKeyException;
import br.com.castudio.sistema_agendamento.infra.adapter.in.web.mapper.ControllerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.*;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(EmailRegisteredException.class)
    public ResponseEntity<MessageResponse<Object>> handleRegisteredEmail(EmailRegisteredException ex){
        var response = ControllerMapper.toError(ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(PasswordsDontMatchException.class)
    public ResponseEntity<MessageResponse<Object>> handleConfirmPasswordDontMatch(PasswordsDontMatchException ex){
        var response = ControllerMapper.toError(ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(WrongKeyException.class)
    public ResponseEntity<MessageResponse<Object>> handleWrongAdminKey(WrongKeyException ex){
        var response = ControllerMapper.toError(ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageResponse<Map<String, String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        for (FieldError error: fieldErrors){
            errors.put(error.getField(), error.getDefaultMessage());
        }

        String msg = "Erro na validacao dos dados inseridos: ";
        var response = ControllerMapper.toError(msg, errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(CredentialsException.class)
    public ResponseEntity<MessageResponse<Object>> handleAuthException(CredentialsException ex){
        var response = ControllerMapper.toError(ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

}
