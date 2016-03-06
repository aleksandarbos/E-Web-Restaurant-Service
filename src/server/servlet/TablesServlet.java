package server.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.entity.KorisnikRestorana;
import server.entity.Sto;
import server.session.RestaurantDaoLocal;

public class TablesServlet extends HttpServlet {

	private static final long serialVersionUID = 2343075842721743113L;

	@EJB
	private RestaurantDaoLocal restoranDao;	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int restaurantId = ((KorisnikRestorana)request.getSession().getAttribute("korisnik")).getPoverenRestoran().getId();		
		
		List<Sto> stolovi = restoranDao.findTables(restaurantId);
		String listaStolova;
		
		if (stolovi.size() != 0) {		
			listaStolova = "";		
			for (Sto sto : stolovi) {
				listaStolova += sto.getBrojStola() + ",";
			}
			listaStolova = listaStolova.substring(0, listaStolova.length()-1);
		} else {
			listaStolova = "nema";	
		}
		
		response.getWriter().write(listaStolova);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] myJsonData = request.getParameterValues("json[]");		
		
		StringBuilder stringBuilder = new StringBuilder();
		InputStream inputStream = request.getInputStream();
        if (inputStream != null) {
        	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            char[] charBuffer = new char[128];
            int bytesRead = -1;
            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                stringBuilder.append(charBuffer, 0, bytesRead);
            }
        } else {
            stringBuilder.append("");
        }
		
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        
        String str = stringBuilder.toString();
        String[] split = str.split(":");
        String split1 = split[1].substring(2, split[1].length()-1);
        String[] tableNumbers = split1.split(",");
        
		int restaurantId = ((KorisnikRestorana)request.getSession().getAttribute("korisnik")).getPoverenRestoran().getId();
		List<Integer> tablesInt = new ArrayList<Integer>();
		for (int i = 0; i < tableNumbers.length; i++) {
			tablesInt.add(Integer.parseInt(tableNumbers[i])); 
		}
		
		restoranDao.createTables(tablesInt, restaurantId);
	}
}
