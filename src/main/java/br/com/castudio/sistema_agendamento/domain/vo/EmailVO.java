package br.com.castudio.sistema_agendamento.domain.vo;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public record EmailVO(String value) implements AttributeConverter<EmailVO, String> {

    public String getEmailValue(){
        return this.value;
    }

    @Override
    public String convertToDatabaseColumn(EmailVO email) {
        return email == null ? null : email.value();
    }

    @Override
    public EmailVO convertToEntityAttribute(String emailInDb) {
        return emailInDb == null ? null : new EmailVO(emailInDb);
    }
}
