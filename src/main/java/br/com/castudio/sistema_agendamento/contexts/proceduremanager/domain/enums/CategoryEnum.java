package br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.enums;

import br.com.castudio.sistema_agendamento.contexts.proceduremanager.domain.exception.IllegalCategoryException;

public enum CategoryEnum {
    EYEBROWS,
    SKIN,
    EYELASHES,
    LIPS;

    public static CategoryEnum fromString(String category){
        try {
            return CategoryEnum.valueOf(category);
        }catch (Exception e){
            throw new IllegalCategoryException(category);
        }
    }
}
