package br.com.castudio.sistema_agendamento.admin.services;

import br.com.castudio.sistema_agendamento.aplication.service.key.KeyServiceImpl;
import br.com.castudio.sistema_agendamento.domain.entity.Key;
import br.com.castudio.sistema_agendamento.domain.exceptions.WrongAdminKeyException;
import br.com.castudio.sistema_agendamento.domain.repository.KeyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class KeyServiceTest {

    @Mock
    private KeyRepository repository;

    @InjectMocks
    private KeyServiceImpl keyService;

    @Test
    void shouldMatchAdminKeysTest(){

        String rightInputKey = "Chave@123";
        String wrongInputKey = "Errado@123";

        Key dbKey = new Key("Chave@123");

        when(repository.findById(1L)).thenReturn(Optional.of(dbKey));


        assertAll(
                ()->assertTrue(keyService.keyIsMatch(rightInputKey)),
                ()->assertThrows(WrongAdminKeyException.class, ()-> keyService.keyIsMatch(wrongInputKey))
        );

    }

}
