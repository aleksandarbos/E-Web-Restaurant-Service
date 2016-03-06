package server.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.entity.Jelo;
import server.entity.Korisnik;
import server.entity.Restoran;
import server.session.FoodDaoBean;
import server.session.FoodDaoLocal;
import server.session.UserDaoLocal;
import server.session.VisitDaoLocal;
import server.session.RestaurantDaoLocal;

public class BeginServlet extends HttpServlet {

	private static final long serialVersionUID = 8277880712041100753L;
	
	@EJB
	private VisitDaoLocal posetaDao;
	@EJB
	private RestaurantDaoLocal restoranDao;
	@EJB
	private UserDaoLocal korisnikDao;
	@EJB
	private FoodDaoLocal jeloDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tipKorisnika = (String) request.getSession().getAttribute("type");
		
		if (tipKorisnika.equals("guest")) {	
			int gostId = ((Korisnik)request.getSession().getAttribute("korisnik")).getId();
			List<Object[]> lista = posetaDao.getPosete(gostId);
			List<Restoran> restorani = restoranDao.findAll();
			
			request.getSession().setAttribute("posete", lista);
			request.getSession().setAttribute("restorani", restorani);
			response.sendRedirect("home-guest.jsp");
			
		} else if (tipKorisnika.equals("manager")) {
			int manId = ((Korisnik)request.getSession().getAttribute("korisnik")).getId();
			Integer assignedRestId = korisnikDao.findManagersRestaurant(manId);
			List<Restoran> restorani = restoranDao.findAll();
			List<Jelo> jela = jeloDao.findMealsInRestaurant(assignedRestId);
			Restoran assignedRest = null;

			for(Restoran rest: restorani) {
				if(rest.getId().equals(assignedRestId))
					assignedRest = rest;
			}
			
			request.setAttribute("restoran", assignedRest);
			request.setAttribute("jela", jela);
			
			request.getRequestDispatcher("home-manager.jsp").forward(request, response);
			//response.sendRedirect("home-manager.jsp");
			
		} else {
			List<Restoran> restorani = restoranDao.findAll();
			request.setAttribute("restorani", restorani);
			
			List<Object[]> menadzeri = korisnikDao.findManagers();
			
			HashMap<Integer, Integer> assignedRestaurants = new HashMap<Integer, Integer>();
			
			for(Object[] arrayOfVals: menadzeri) {
				Integer assignedRestaurant = null;
				try{ 
					assignedRestaurant = korisnikDao.findManagersRestaurant((int) arrayOfVals[0]);
					assignedRestaurants.put((int) arrayOfVals[0], assignedRestaurant);
				} catch(NoResultException  nre) {
					assignedRestaurants.put((int) arrayOfVals[0], null);
				}
				 
			}
			request.setAttribute("menadzeri", menadzeri);		
			request.setAttribute("assignedRestaurants", assignedRestaurants);
			//response.sendRedirect("home-admin.jsp");
			request.getRequestDispatcher("home-admin.jsp").forward(request, response);

		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int posetaId = Integer.parseInt(request.getParameter("visit"));
		int rate = Integer.parseInt(request.getParameter("rate"));
		
		posetaDao.rateVisit(posetaId, rate);

		response.sendRedirect(response.encodeRedirectURL("./VisitsServlet"));
	}
}
