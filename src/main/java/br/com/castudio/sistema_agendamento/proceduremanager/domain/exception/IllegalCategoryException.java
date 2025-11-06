package br.com.castudio.sistema_agendamento.proceduremanager.domain.exception;

public class IllegalCategoryException extends IllegalArgumentException {
    public IllegalCategoryException(String category){ super("Categoria invalida: "+category);}
}
