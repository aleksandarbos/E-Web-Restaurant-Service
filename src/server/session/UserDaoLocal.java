package server.session;

import java.util.List;

import server.entity.Korisnik;
import server.entity.KorisnikGost;

public interface UserDaoLocal extends GenericDaoLocal<Korisnik, Integer> {
	
	public Korisnik findKorisnikLogovanje(String email, String lozinka);
	
	public List<Object[]> findManagers();
	
	public boolean createAccount(String ime, String prezime, String adresa, String email, String lozinka, String tip);
	
	public void updateAccount(int id, String ime, String prezime, String adresa, String email, String lozinka);
	
	public int findManagersRestaurant(int managersId);
	
	public void updateManagersRestaurants(int managerId, int restaurantId);
	
	public List<KorisnikGost> findFriends(int id);
	
	public List<KorisnikGost> findAllClients();
	
	public List<KorisnikGost> findPersons(String name, String surname, int userId);
	
	public void activateAccount(String email, Boolean activate);
	
}
