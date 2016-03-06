package server.session;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import server.entity.KorisnikGost;
import server.entity.Prijatelji;

@Stateless
@Local(FriendsDaoLocal.class)
public class FriendsDaoBean extends GenericDaoBean<Prijatelji, Integer> implements FriendsDaoLocal {
	
	public void removeFriend(int userId, int friendId) {
		Prijatelji prijatelji1 = findPrijatelji(userId, friendId);
		Prijatelji prijatelji2 = findPrijatelji(friendId, userId);
		
		if (prijatelji1 != null)
			em.remove(prijatelji1);
		if (prijatelji2 != null)
			em.remove(prijatelji2);
	}	
	
	public Prijatelji findPrijatelji(int userId, int friendId) {

		Query q = em.createQuery("SELECT pr FROM Prijatelji pr WHERE pr.osoba.id = :userId and pr.prijateljiSuMu.id = :friendId");
		q.setParameter("userId", userId);
		q.setParameter("friendId", friendId);		
		Prijatelji result = (Prijatelji) q.getSingleResult();
		
		return result;
	}
	

	public KorisnikGost addFriend(int personId, int userId) {
		
		KorisnikGost osobaDodata = em.find(KorisnikGost.class, personId);
		KorisnikGost osobaKorisnik = em.find(KorisnikGost.class, userId);
		
		Prijatelji prijatelji1 = new Prijatelji(osobaDodata, osobaKorisnik);
		Prijatelji prijatelji2 = new Prijatelji(osobaKorisnik, osobaDodata);
		
		em.persist(prijatelji1);
		em.persist(prijatelji2);
		
		return osobaDodata;
	}
}
