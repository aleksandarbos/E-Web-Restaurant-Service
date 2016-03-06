package server.session;

import java.util.List;

import server.entity.Restoran;
import server.entity.Sto;

public interface RestaurantDaoLocal extends GenericDaoLocal<Restoran, Integer> {

	public void createRestaurant(String slika, String naziv, String opis, String adresa, String kontakt, Double lokacijaLong, Double lokacijaLat);

	public void updateRestaurant(int id, String slika, String naziv, String opis, String adresa, String kontakt, Double lokacijaLong, Double lokacijaLat);
	
	public String findRate(int id);
	
	public String findRate(int id, int userId);
	
	public List<Sto> findTables(int restaurantId);

	public void createTables(List<Integer> tables, int restaurantId);
}
