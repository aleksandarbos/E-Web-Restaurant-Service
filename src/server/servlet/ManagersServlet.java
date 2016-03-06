package server.servlet;

import server.entity.Restoran;
import server.session.UserDaoLocal;
import server.session.RestaurantDaoLocal;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagersServlet extends HttpServlet {

	private static final long serialVersionUID = -1992474462125530949L;

	@EJB
	private UserDaoLocal korisnikDao;	
	@EJB
	private RestaurantDaoLocal restoranDao;	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Object[]> menadzeri = korisnikDao.findManagers();		
		request.setAttribute("menadzeri", menadzeri);		

		List<Restoran> restorani = restoranDao.findAll();
		request.setAttribute("restorani", restorani);			
		
		request.getRequestDispatcher("home-manager.jsp").forward(request, response);
	}
	
	/**
	 * Assign restaurant to manager..
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parameter = request.getParameter("manager");
		String value = request.getParameter("pick_restaurant"); 
		String user = request.getParameter("manager_id"); 
		
		if (parameter != null) {
			int managersId = Integer.parseInt(parameter);
			
			int idRestorana = korisnikDao.findManagersRestaurant(managersId);
			response.getWriter().write(String.valueOf(idRestorana));
			return;
		}
		
		int restaurantId = Integer.parseInt(value);
		int managerId = Integer.parseInt(user);
		
		korisnikDao.updateManagersRestaurants(managerId, restaurantId);
		
		response.sendRedirect(response.encodeRedirectURL("./ManagersServlet"));
	}
	
}
