package server.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.entity.KorisnikGost;
import server.session.UserDaoLocal;
import server.session.FriendsDaoLocal;

public class FriendsServlet extends HttpServlet {

	private static final long serialVersionUID = -1566580062592546971L;

	@EJB
	private UserDaoLocal korisnikDao;
	
	@EJB
	private FriendsDaoLocal prijateljiDao;	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		int id = ((KorisnikGost)request.getSession().getAttribute("korisnik")).getId(); 
		
		if (name == null) {		// obican ispis svih prijatelja
			List<KorisnikGost> prijatelji = korisnikDao.findFriends(id);
			List<KorisnikGost> guests = korisnikDao.findAllClients();
			
			request.setAttribute("prijatelji", prijatelji);					
			
			request.setAttribute("korisnici", guests);
			
			request.getRequestDispatcher("home-guest-friends.jsp").forward(request, response);
		} else {
			List<KorisnikGost> osobe = korisnikDao.findPersons(name, surname, id);	// pretraga
			
			response.setCharacterEncoding("UTF-8");
			/*ObjectMapper mapper = new ObjectMapper();
			String listaOsoba = mapper.writeValueAsString(osobe);
			response.getWriter().write(listaOsoba);	*/		
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String nameIdPair = request.getParameter("personId");
		String instruction = request.getParameter("instruction");
		
		String[] split;
		Integer personId=null;
		
		if(nameIdPair!= null) {
			split = nameIdPair.split("-");
			personId = Integer.parseInt(split[1]);
		}
		
		int userId = ((KorisnikGost)request.getSession().getAttribute("korisnik")).getId();
		
		if (instruction.equals("removeFriend")) {
			prijateljiDao.removeFriend(userId, Integer.parseInt(request.getParameter("id")));			
			response.sendRedirect(response.encodeRedirectURL("./FriendsServlet"));
		} else {
			KorisnikGost dodat = prijateljiDao.addFriend(personId, userId);	
			response.setCharacterEncoding("UTF-8");
			response.sendRedirect(response.encodeRedirectURL("./FriendsServlet"));

		}
	}
	
}
