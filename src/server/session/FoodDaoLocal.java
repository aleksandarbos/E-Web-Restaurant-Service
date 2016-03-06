package server.session;

import java.util.List;

import server.entity.Jelo;

public interface FoodDaoLocal extends GenericDaoLocal<Jelo, Integer> {

	public List<Jelo> findMealsInRestaurant(int restaurantId);

	public void createMeal(String naziv, String opis, int cena, int restoranId);
	
	public void updateMeal(int id, String naziv, String opis, int cena);
	
}
