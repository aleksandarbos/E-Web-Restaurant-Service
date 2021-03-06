package server.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		try {			
			request.getSession().setAttribute("korisnik", null);
			request.getSession().invalidate();
			response.sendRedirect(response.encodeRedirectURL("login.jsp"));		
		} catch (IOException e) {
			throw e;
		}
	}

	protected void doPost(HttpServletRequest request, 	HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
