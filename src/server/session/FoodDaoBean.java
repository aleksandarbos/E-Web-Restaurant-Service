package server.session;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import server.entity.Jelo;
import server.entity.Restoran;

@Stateless
@Local(FoodDaoLocal.class)
public class FoodDaoBean extends GenericDaoBean<Jelo, Integer> implements FoodDaoLocal  {

	public List<Jelo> findMealsInRestaurant(int restaurantId) {

		Query q = em.createQuery("SELECT j FROM Jelo j, Restoran r WHERE j.restoranSaJelom.id = r.id and r.id = :restoranId");
		q.setParameter("restoranId", restaurantId);		
		@SuppressWarnings("unchecked")
		List<Jelo> jela = q.getResultList();
		
		return jela;
	}
	
	public void createMeal(String naziv, String opis, int cena, int restoranId) {
		
		Restoran restoran = em.find(Restoran.class, restoranId);		
		
		Jelo jelo = new Jelo(naziv, opis, cena, restoran);
		em.persist(jelo);
	}
	
	public void updateMeal(int id, String naziv, String opis, int cena) {
		
		Jelo jelo = em.find(Jelo.class, id);
		
		jelo.setNaziv(naziv);
		jelo.setOpis(opis);
		jelo.setCena(cena);
		
		em.merge(jelo);
	}
}
