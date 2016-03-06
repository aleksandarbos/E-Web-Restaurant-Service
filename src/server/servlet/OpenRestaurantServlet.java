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

public class OpenRestaurantServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8985204755959660540L;
	
	
	@EJB
	private RestaurantDaoLocal restoranDao;	
	@EJB
	private FoodDaoLocal jelaDao;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		request.setCharacterEncoding("UTF-8");
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Restoran rest = restoranDao.findById(id);
		request.setAttribute("restoran", rest);
		
		request.getRequestDispatcher("home-guest-restaurant.jsp").forward(request, response);
	}	
}
