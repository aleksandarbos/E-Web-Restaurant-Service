package server.servlet;

import server.entity.Korisnik;
import server.entity.KorisnikGost;
import server.entity.KorisnikRestorana;
import server.session.UserDaoLocal;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInServlet extends HttpServlet {
	
	private static final long serialVersionUID = 3450456892394302136L;
	
	@EJB
	private UserDaoLocal korisnikDao;	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");	
		
		/*String provera = request.getParameter("provera");
		if (provera != null) {
			Korisnik korisnik = (Korisnik) request.getSession().getAttribute("korisnik");
			if (korisnik != null)
				response.getWriter().write("prijavljen");
			else
				response.getWriter().write("odjavljen");
			return;
		}*/
		
		try {			
			String email = request.getParameter("email");
			String lozinka = request.getParameter("pwd");
			
			Korisnik korisnik = korisnikDao.findKorisnikLogovanje(email, lozinka);
			
			if (korisnik != null) {	
				request.getSession().setAttribute("korisnik", korisnik);
				//getServletContext().getRequestDispatcher("/index.html").forward(request, response);
				if (korisnik instanceof KorisnikGost) {
					request.getSession().setAttribute("type", "guest");
				} else if (korisnik instanceof KorisnikRestorana) {
					request.getSession().setAttribute("type", "manager");
				} else {
					request.getSession().setAttribute("type", "systemManager");
				}
				response.sendRedirect(response.encodeRedirectURL("./BeginServlet"));
			} else {
				response.sendRedirect(response.encodeRedirectURL("login.jsp"));
			}
			
		} catch (EJBException e) {
			if (e.getCause().getClass().equals(NoResultException.class)) {
				response.sendRedirect(response.encodeRedirectURL("login.jsp"));
			} else {
				throw e;
			}
		} catch (IOException e) {
			throw e;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
