package server.entity;

import java.io.Serializable;

public class Mail implements Serializable {

	private static final long serialVersionUID = 7672672828010039526L;
	public String email;
    public String subject;
    public String body;

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }
}