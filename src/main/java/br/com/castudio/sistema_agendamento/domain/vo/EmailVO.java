package br.com.castudio.sistema_agendamento.domain.vo;

public record EmailVO(String value) {

    public String getEmailValue(){
        return this.value;
    }

}
