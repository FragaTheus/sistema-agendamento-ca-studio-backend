package br.com.castudio.sistema_agendamento.controllers.handler;

import br.com.castudio.sistema_agendamento.aplication.dto.message.MessageResponse;
import br.com.castudio.sistema_agendamento.domain.exceptions.EmailAlreadyExistException;
import br.com.castudio.sistema_agendamento.domain.exceptions.PasswordDontMathcException;
import br.com.castudio.sistema_agendamento.domain.exceptions.WrongAdminKeyException;
import br.com.castudio.sistema_agendamento.domain.exceptions.WrongCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.*;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<MessageResponse<Void>> handleRegisteredEmail(EmailAlreadyExistException ex){
        var response = MessageResponse.<Void>error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(PasswordDontMathcException.class)
    public ResponseEntity<MessageResponse<Void>> handleConfirmPasswordDontMatch(PasswordDontMathcException ex){
        var response = MessageResponse.<Void>errorWithoutData(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(WrongAdminKeyException.class)
    public ResponseEntity<MessageResponse<Void>> handleWrongAdminKey(WrongAdminKeyException ex){
        var response = MessageResponse.<Void>errorWithoutData(ex.getMessage());
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
        var response = MessageResponse.errorWithData(msg, errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(WrongCredentialsException.class)
    public ResponseEntity<MessageResponse<Void>> handleAuthException(WrongCredentialsException ex){
        var response = MessageResponse.<Void>error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

}
