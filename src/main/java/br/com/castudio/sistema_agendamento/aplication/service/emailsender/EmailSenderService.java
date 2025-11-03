package br.com.castudio.sistema_agendamento.aplication.service.emailsender;

public interface EmailSenderService {

    public void sendEmail(String to, String subject, String body);

}
