package server.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import server.entity.Korisnik;
import server.entity.KorisnikGost;
import server.entity.KorisnikRestorana;
import server.entity.KorisnikSistema;
import server.entity.Restoran;

@Stateless
@Local(UserDaoLocal.class)
public class UserDaoBean extends GenericDaoBean<Korisnik, Integer> implements UserDaoLocal {

	public Korisnik findKorisnikLogovanje(String email, String lozinka) {
		Query q = em.createQuery("SELECT k FROM Korisnik k WHERE k.email like :prosledjeniMejl AND k.lozinka LIKE :prosledjenaLozinka");
		q.setParameter("prosledjeniMejl", email);
		q.setParameter("prosledjenaLozinka", lozinka);
		Korisnik result = (Korisnik) q.getSingleResult();
		if (result instanceof KorisnikGost) {
			if (((KorisnikGost) result).getAktiviran())
				return result;
			else
				return null;
		}
		return result;
	}

	public List<Object[]> findManagers() {
		Query q = em.createQuery("SELECT k.id, k.slika, k.ime, k.prezime, k.adresa, k.email, k.tip, k.lozinka"
								+ " FROM Korisnik k WHERE k.tip like 'MR' OR k.tip LIKE 'MS'");
		
		@SuppressWarnings("unchecked")
		List<Object[]> result = q.getResultList();

		return result;
	}
	
	public List<KorisnikGost> findAllClients() {
		Query q = em.createQuery("SELECT k FROM Korisnik k WHERE k.tip like 'GR'");
		
		List<KorisnikGost> result = q.getResultList();

		return result;
	}	
	
	public boolean createAccount(String ime, String prezime, String adresa, String email, String lozinka, String tip) {

		if (tip.equals("guest") || tip.equals("GR")) {
			KorisnikGost noviKorisnik = new KorisnikGost(null, ime, prezime, adresa, email, lozinka, false, null, null, null);
			em.persist(noviKorisnik);
			return true;
		} else if (tip.equals("manager") || tip.equals("MR")) {
			KorisnikRestorana noviKorisnik = new KorisnikRestorana(null, ime, prezime, adresa, email, lozinka, null);
			em.persist(noviKorisnik);
			return true;
		} else if (tip.equals("systemManager") || tip.equals("MS")) {
			KorisnikSistema noviKorisnik = new KorisnikSistema(null, ime, prezime, adresa, email, lozinka);
			em.persist(noviKorisnik);
			return true;
		}		
		
		return false;
	}
	
	public void updateAccount(int id, String ime, String prezime, String adresa, String email, String lozinka) {

		Korisnik korisnik = em.find(Korisnik.class, id);
		
		korisnik.setIme(ime);
		korisnik.setPrezime(prezime);
		korisnik.setAdresa(adresa);
		korisnik.setEmail(email);
		korisnik.setLozinka(lozinka);
		
		em.persist(korisnik);
	}
	
	public void activateAccount(String email, Boolean activate) {
		KorisnikGost guest = null;
		try{
			Query q = em.createQuery("SELECT k FROM KorisnikGost k WHERE k.email = :email");
			q.setParameter("email", email);
			guest =  (KorisnikGost) q.getSingleResult();
		} catch (NoResultException nre) {
				
		}
		guest.setAktiviran(activate);
		em.persist(guest);
		
	}
	
	public int findManagersRestaurant(int managersId) {

		int result = -1;
		
		try{
			Query q = em.createQuery("SELECT k.poverenRestoran.id FROM KorisnikRestorana k WHERE k.id = :managersId");
			q.setParameter("managersId", managersId);
			 result = (int) q.getSingleResult();
			} catch (NoResultException nre) {
				
			}
				
		return result;
	}
	
	public void updateManagersRestaurants(int managerId, int restaurantId) {

		KorisnikRestorana korisnik = (KorisnikRestorana) em.find(Korisnik.class, managerId);
		Restoran restoran;
		
		if (restaurantId != 0)
			restoran = em.find(Restoran.class, restaurantId);
		else
			restoran = null;
		
		korisnik.setPoverenRestoran(restoran);
		
		em.merge(korisnik);
	}

	@Override
	public List<KorisnikGost> findFriends(int id) {
		Query q = em.createQuery("SELECT k2 FROM KorisnikGost k1, KorisnikGost k2, Prijatelji pr WHERE " +
				"k1.id = :korisnikId and k1.id = pr.osoba.id and pr.prijateljiSuMu.id = k2.id");
		q.setParameter("korisnikId", id);
		@SuppressWarnings("unchecked")
		List<KorisnikGost> result = q.getResultList();
		
		if (result == null)
			result = new ArrayList<KorisnikGost>();
		
		return result;

	}
	
	public List<KorisnikGost> findPersons(String name, String surname, int userId) {
		List<KorisnikGost> queryResult = null;
		Query q;
		
		if (surname.equals("")) {
			q = em.createQuery("SELECT k FROM KorisnikGost k WHERE k.ime like :ime");// and k.aktiviran = true
			q.setParameter("ime", name);
		} else if (name.equals("")) {
			q = em.createQuery("SELECT k FROM KorisnikGost k WHERE k.prezime like :prezime");
			q.setParameter("prezime", surname);
		} else {
			q = em.createQuery("SELECT k FROM KorisnikGost k WHERE k.ime like :ime and k.prezime like :prezime");
			q.setParameter("ime", name);			
			q.setParameter("prezime", surname);
		}
		queryResult = q.getResultList();
		
		if (queryResult == null) 
			return new ArrayList<KorisnikGost>();
		
		List<KorisnikGost> vecPrijateljiCelo = findFriends(userId);
		List<Integer> vecPrijatelji = new ArrayList<Integer>();
		vecPrijatelji.add(userId);
		for (KorisnikGost prijatelj : vecPrijateljiCelo) {
			vecPrijatelji.add(prijatelj.getId());
		}

		List<KorisnikGost> result = new ArrayList<KorisnikGost>();
		for (KorisnikGost osoba : queryResult) {
		    if (!vecPrijatelji.contains(osoba.getId())) {
		    	result.add(osoba);
		    }
		}
		
		return result;
	}
}
