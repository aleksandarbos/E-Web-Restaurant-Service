package server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.entity.KorisnikRestorana;
import server.session.FoodDaoLocal;

public class MealsServlet extends HttpServlet {

	private static final long serialVersionUID = -5369067833292131082L;

	@EJB
	private FoodDaoLocal jeloDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*String tipKorisnika = (String) request.getSession().getAttribute("tip");

		if (tipKorisnika.equals("gost")) {	
			int restoranId = Integer.parseInt(request.getParameter("id"));
			List<Jelo> jela = jeloDao.findMealsInRestaurant(restoranId);

			response.setCharacterEncoding("UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			String listaJela = mapper.writeValueAsString(jela);
			response.getWriter().write(listaJela);
			
		} else if (tipKorisnika.equals("restorana")) {
			Restoran poverenRestoran = ((KorisnikRestorana)request.getSession().getAttribute("korisnik")).getPoverenRestoran();
			List<Jelo> jela;
			int code;
			if (poverenRestoran == null) {
				code = 0;	
				jela = new ArrayList<Jelo>();		
			} else {
				code = 2;
				int restoranId = poverenRestoran.getId();			
				jela = jeloDao.findMealsInRestaurant(restoranId);
				
			}
			request.setAttribute("dodeljenRestoran", code);
			request.setAttribute("jela", jela);
			request.getRequestDispatcher("meals.jsp").forward(request, response);
		}*/
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String idString = request.getParameter("id");
		String naziv = request.getParameter("name"); 
		String opis = request.getParameter("description");
		int cena = Integer.parseInt(request.getParameter("price")); 
		
		if (idString != null) {
			int id = Integer.parseInt(idString);
			jeloDao.updateMeal(id, naziv, opis, cena);
		} else {
			int restoranId = ((KorisnikRestorana)request.getSession().getAttribute("korisnik")).getPoverenRestoran().getId();			
			jeloDao.createMeal(naziv, opis, cena, restoranId);
		}

		response.sendRedirect(response.encodeRedirectURL("./BeginServlet"));		
	}	
}
