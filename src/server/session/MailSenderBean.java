package server.session;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import server.entity.Mail;

@Stateless
@Local(MailSenderLocal.class)
public class MailSenderBean implements MailSenderLocal {

    @Resource(name = "JmsConnectionFactory")
    private ConnectionFactory qcf;

    @Resource(name = "MailQueue")
    private Queue mailQueue;

    public void sendMail(Mail mail) {

        Connection connection;
        Session session;
        MessageProducer producer;

        try {
            connection = qcf.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(mailQueue);

            ObjectMessage object = session.createObjectMessage();
            object.setObject(mail);

            producer.send(object);
            producer.close();
            session.close();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendConfirmationEmail(String email, String user, int code) {

        Mail mail = new Mail();
        mail.setEmail(email);
        mail.setSubject("Account confirmation");

        String body = String.format("Dear %s, \n" +
                                    "an account creation request has been issued with your email address." +
                                    "Please follow the link bellow in order to activate it.\n" +
                                    "http://localhost:8080/ISA-project/AccountServlet?email=%s&activate=1",
                                    user, email);
        mail.setBody(body);
        sendMail(mail);
    }

	@Override
	public Class<Mail> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mail findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mail> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mail> findBy(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mail persist(Mail entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mail merge(Mail entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Mail entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
		
}