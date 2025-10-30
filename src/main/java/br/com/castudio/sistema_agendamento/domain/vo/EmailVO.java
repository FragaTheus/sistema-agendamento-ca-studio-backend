package br.com.castudio.sistema_agendamento.domain.vo;

public record EmailVO(String value) {

    public EmailVO{
        if (value == null || !value.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")){
            throw new IllegalArgumentException("Email invalido");
        }
    }

}
