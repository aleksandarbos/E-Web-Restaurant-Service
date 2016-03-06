package server.servlet;

import server.entity.Korisnik;
import server.session.UserDaoLocal;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccountServlet extends HttpServlet {

	private static final long serialVersionUID = -8292631789105028820L;

	@EJB
	private UserDaoLocal korisnikDao;	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String activation = request.getParameter("activate");
		String tipKorisnika = (String) request.getSession().getAttribute("type");
		
		if(activation != null && activation.equals("1")) {
			
			String email = request.getParameter("email");
			korisnikDao.activateAccount(email, true);
			response.sendRedirect(response.encodeRedirectURL("home-login.jsp"));
		
		}
		
		if (tipKorisnika.equals("guest")) {	
			response.sendRedirect(response.encodeRedirectURL("home-guest.jsp"));
			
		} else if (tipKorisnika.equals("manager")) {
			response.sendRedirect(response.encodeRedirectURL("home-manager.jsp"));
			
		} else {
			response.sendRedirect(response.encodeRedirectURL("home-admin.jsp"));
		}
	}
	
	/**
	 * Update existing account to DB..
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String adress = request.getParameter("address");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Integer assigned;
		
		assigned = (request.getParameter("assigned") == null)?null:Integer.parseInt(request.getParameter("assigned"));
		
		korisnikDao.updateAccount(id, name, surname, adress, email, password);
		
		if(assigned != null) // its manager actually
			korisnikDao.updateManagersRestaurants(id, assigned);

		Korisnik korisnik = korisnikDao.findById(id);
		request.getSession().setAttribute("korisnik", korisnik);		
		
		response.sendRedirect(response.encodeRedirectURL("./BeginServlet"));
	}
}
