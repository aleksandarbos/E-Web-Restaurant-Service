package server.session;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import server.entity.Poseta;

@Stateless
@Local(VisitDaoLocal.class)
public class VisitDaoBean extends GenericDaoBean<Poseta, Integer> implements VisitDaoLocal {

	public List<Object[]> getPosete(int idGosta) {
	
		Query q = em.createQuery("select p.id, r.naziv, r.opis, z.pocetakDatum, p.ocena "+
				"from Rezervacija z, Poseta p, Korisnik k, RezervacijaSto rs, Sto s, Restoran r "+ 
				"where k.id = :idPosetioca and k.id = p.posetilac.id and p.posetaPrihvacena = true and " + 
				"p.rezervacija.id = z.id and z.pocetakDatum < :vremeSad and z.id = rs.rezervacija.id and " +
				"rs.sto.id = s.id and s.maticniRestoran.id = r.id");
		q.setParameter("idPosetioca", idGosta);
		q.setParameter("vremeSad", new Date());
		
		@SuppressWarnings("unchecked")
		List<Object[]> result = q.getResultList();
		
		for (Object list : result) {
			Date date = (Date) ((Object[]) list)[3];
			String dateString = new SimpleDateFormat("dd.MM.yyyy.").format(date);			
			((Object[]) list)[3] = dateString;
		}		
		
		return result;
	}
	
	public void rateVisit(int posetaId, int rate) {
		Poseta poseta = em.find(Poseta.class, posetaId);
		
		poseta.setOcena(rate);
		
		em.merge(poseta);
		
	}
}
