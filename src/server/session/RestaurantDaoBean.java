package server.session;

import java.text.DecimalFormat;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import server.entity.Restoran;
import server.entity.Sto;

@Stateless
@Local(RestaurantDaoLocal.class)
public class RestaurantDaoBean extends GenericDaoBean<Restoran, Integer> implements RestaurantDaoLocal {

	public void createRestaurant(String slika, String naziv, String opis, String adresa, String kontakt, Double lokacijaLong, Double lokacijaLat) {
		Restoran newRestaurant = new Restoran(slika, naziv, opis, adresa, kontakt, lokacijaLong, lokacijaLat, null, null, null);
		em.persist(newRestaurant);
	}

	public void updateRestaurant(int id, String slika, String naziv, String opis, String adresa, String kontakt, Double lokacijaLong, Double lokacijaLat) {
		
		Restoran restaurant = em.find(Restoran.class, id);
		
		restaurant.setSlika(slika);
		restaurant.setNaziv(naziv);
		restaurant.setOpis(opis);
		restaurant.setAdresa(adresa);
		restaurant.setKontakt(kontakt);
		restaurant.setLokacijaLat(lokacijaLat);
		restaurant.setLokacijaLong(lokacijaLong);
		
		em.merge(restaurant);
	}
	
	public String findRate(int id) {

		Query q = em.createQuery("SELECT p.ocena FROM Poseta p, Rezervacija z, RezervacijaSto rs, Sto s, Restoran r WHERE "+
				"r.id = :restoranId and r.id = s.maticniRestoran.id and s.id = rs.sto.id and rs.rezervacija.id = z.id and "+
				"z.id = p.rezervacija.id and p.ocena <> 0");
		q.setParameter("restoranId", id);
		@SuppressWarnings("unchecked")
		List<Integer> rate = q.getResultList();
		
		if (rate.size() == 0) {
			return "";
		}
		
		int sum = 0, count = 0;
		for (Integer value : rate) {
			sum += value;
			count++;			
		}

		double result = (sum * 1.0) / (count);
	    DecimalFormat f = new DecimalFormat("##.00");    
		
		return f.format(result);
	}
	
	public List<Sto> findTables(int restaurantId) {
		Query q = em.createQuery("SELECT s FROM Sto s, Restoran r WHERE r.id = :restoranId and r.id = s.maticniRestoran.id");
		q.setParameter("restoranId", restaurantId);
		@SuppressWarnings("unchecked")
		List<Sto> tables = q.getResultList();
		return tables;
	}
	
	public void createTables(List<Integer> tables, int restaurantId) {

		Restoran restaurant = em.find(Restoran.class, restaurantId);
		List<Sto> dataBaseTables = findTables(restaurantId);
		
		for(Sto st:dataBaseTables) {	// reset state of that restaurant
			em.remove(st);
		}
		
		for (int i = 0; i < tables.size(); i++) {
			Sto sto = new Sto(tables.get(i), restaurant, null);
			em.persist(sto);
		}
	}

	@Override
	public String findRate(int id, int userId) {
		Query q = em.createQuery("SELECT p.ocena FROM Poseta p, Prijatelji pr, Korisnik k1, Korisnik k2,"
				+ "Restoran r, Sto s, RezervacijaSto rs, Rezervacija z WHERE "
				+ "k1.id = :korisnikId and k1.id = pr.osoba.id and pr.prijateljiSuMu.id = k2.id and "
				+ "p.posetilac.id = k2.id and r.id = :restoranId and r.id = s.maticniRestoran.id and "
				+ "s.id = rs.sto.id and rs.rezervacija.id = z.id and z.id = p.rezervacija.id and p.ocena <> 0 ");
		q.setParameter("restoranId", id);
		q.setParameter("korisnikId", userId);
		@SuppressWarnings("unchecked")
		List<Integer> rate = q.getResultList();		
		
		if (rate.size() == 0) {
			return "(nije ocenjen)";
		}
		
		int sum = 0, count = 0;
		for (Integer value : rate) {
			sum += value;
			count++;			
		}

		double result = (sum * 1.0) / (count);
	    DecimalFormat f = new DecimalFormat("##.00");    
		
		return f.format(result);
	}

}
