package server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.session.UserDaoLocal;
import server.session.MailSenderLocal;

public class CreateAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 495320396778396075L;

	@EJB
	private UserDaoLocal korisnikDao;	
	@EJB
	private MailSenderLocal mailDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		try {			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			String surname = request.getParameter("surname");
			String name = request.getParameter("name");
			String type = request.getParameter("role");
			
			if(password == null)
				password = request.getParameter("pass1");
			
			if(type != null)
				type = (type.equals("System Manager"))?"MS":"MR";
			else
				type = "GR";
			
			if (korisnikDao.createAccount(name, surname, address, email, password, type)) {
				if (type.equals("guest") || type.equals("GR")) {
					mailDao.sendConfirmationEmail(email, name, 0);
					response.sendRedirect(response.encodeRedirectURL("login.jsp"));
				} else if (type.equals("manager") || type.equals("MR")) {
					response.sendRedirect(response.encodeRedirectURL("./BeginServlet"));
				} else if (type.equals("systemManager") || type.equals("MS")) {
					response.sendRedirect(response.encodeRedirectURL("./BeginServlet"));
				}
			} else {
				if (type.equals("guest")) {
					response.sendRedirect(response.encodeRedirectURL("signup.html"));
				} else if (type.equals("manager")) {
					response.sendRedirect(response.encodeRedirectURL("./ManagersServlet"));
				} else if (type.equals("systemManager")) {
					
				}
			}
			
		} catch (EJBException e) {
			if (e.getCause().getClass().equals(NoResultException.class)) {
				response.sendRedirect(response.encodeRedirectURL("signup.html"));
			} else {
				throw e;
			}
		}
	}

	protected void doPost(HttpServletRequest request, 	HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
