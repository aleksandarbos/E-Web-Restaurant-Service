package server.session;

import server.entity.Mail;

public interface MailSenderLocal extends GenericDaoLocal<Mail, Integer>  {

    void sendMail(Mail mail);
    void sendConfirmationEmail(String email, String username, int code);

}