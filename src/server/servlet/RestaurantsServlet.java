package server.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.entity.Jelo;
import server.entity.KorisnikRestorana;
import server.entity.Restoran;
import server.session.FoodDaoLocal;
import server.session.RestaurantDaoLocal;

public class RestaurantsServlet extends HttpServlet {

	private static final long serialVersionUID = 964588230904704281L;

	@EJB
	private RestaurantDaoLocal restoranDao;	
	@EJB
	private FoodDaoLocal jelaDao;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String tipKorisnika = (String) request.getSession().getAttribute("type");
		
		if (tipKorisnika.equals("guest")) {	
			
		} else if (tipKorisnika.equals("manager")) {
			Restoran poverenRestoran = ((KorisnikRestorana)request.getSession().getAttribute("korisnik")).getPoverenRestoran();
			if (poverenRestoran == null) {
				request.setAttribute("restoran", null);	
			} else {
				int restaurantId = poverenRestoran.getId();
				Restoran restoran = restoranDao.findById(restaurantId);
				String rate = restoranDao.findRate(restaurantId);
				List<Jelo> jela = jelaDao.findMealsInRestaurant(restaurantId);
				request.setAttribute("jela", jela);
				request.setAttribute("restoran", restoran);	
				if (rate.equals(""))
					request.setAttribute("ocena", "(nije ocenjen)");
				else
					request.setAttribute("ocena", rate);
			}
			request.getRequestDispatcher("home-manager.jsp").forward(request, response);			
		} else {
			List<Restoran> restorani = restoranDao.findAll();		
			request.setAttribute("restorani", restorani);	
			request.getRequestDispatcher("home-admin.jsp").forward(request, response);
		}
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String slika = request.getParameter("photo"); 
		String naziv = request.getParameter("name"); 
		String opis = request.getParameter("description"); 
		Double lokacijaLat = null;
		Double lokacijaLong = null; 
		String adresa = request.getParameter("address"); 
		String kontakt = request.getParameter("contact");
		
		/*if (slika.equals("")) 
			slika = null;*/
		
		if (id == null) {
			restoranDao.createRestaurant(slika, naziv, opis, adresa, kontakt, lokacijaLong, lokacijaLat);
		} else {
			int idInt = Integer.parseInt(id);
			restoranDao.updateRestaurant(idInt, slika, naziv, opis, adresa, kontakt, lokacijaLong, lokacijaLat);
		}
		
		response.sendRedirect(response.encodeRedirectURL("./RestaurantsServlet"));
	}	
}
