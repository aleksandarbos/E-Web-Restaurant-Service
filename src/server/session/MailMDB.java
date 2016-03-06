package server.session;


import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import server.entity.Mail;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "MailQueue")
        }
)
public class MailMDB implements MessageListener {

    public MailMDB() {}

    @Resource(name = "Mail")
    private Session session;

    public void onMessage(Message message) {

        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage obj = (ObjectMessage) message;
                Mail mail = (Mail) obj.getObject();

                MimeMessage m = new MimeMessage(session);
                m.setFrom(new InternetAddress("aleksandar1709@gmail.com"));
                Address toAddress = new InternetAddress(mail.email);
                m.addRecipient(MimeMessage.RecipientType.TO, toAddress);
                m.setSubject(mail.subject);
                m.setContent(mail.body, "text/plain");
                Transport.send(m);

                System.out.println(mail.subject);
            } else {
                System.out.println("MESSAGE BEAN: Message of wrong type: " + message.getClass().getName());
            }
        } catch (JMSException | MessagingException e) {
            e.printStackTrace();
        }
    }

}