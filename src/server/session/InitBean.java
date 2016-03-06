package server.session;

import java.util.Date;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import server.entity.Jelo;
import server.entity.KorisnikGost;
import server.entity.KorisnikRestorana;
import server.entity.KorisnikSistema;
import server.entity.Poseta;
import server.entity.Prijatelji;
import server.entity.Restoran;
import server.entity.Rezervacija;
import server.entity.RezervacijaSto;
import server.entity.Sto;

@Stateless
@Remote(Init.class)
public class InitBean implements Init {

	@PersistenceContext(unitName = "ISA-project")
	EntityManager em;
	
	public void init() {
		
		KorisnikGost korisnik1 = new KorisnikGost(null, "Gost1", "Gostovic", "Gostica 15", "gost1@gmail.com", "gost1", true, null, null, null);
		em.persist(korisnik1);		
		
		KorisnikGost korisnik2 = new KorisnikGost(null, "Gost2", "Gostikovic", "Gostanska 19", "gost2@gmail.com", "gost2", false, null, null, null);
		em.persist(korisnik2);		
		
		KorisnikSistema korisnik3 = new KorisnikSistema(null, "Admin", "Admirovic", "Adminska 11", "admin@gmail.com", "admin");
		em.persist(korisnik3);
		
		KorisnikRestorana korisnik4 = new KorisnikRestorana(null, "Menadzer", "Menadzerovic", "Menadzerska 99", "men1@gmail.com", "men1", null);
		em.persist(korisnik4);		
		
		
		Prijatelji prijatelji1 = new Prijatelji(korisnik1, korisnik2);
		em.persist(prijatelji1);		
		Prijatelji prijatelji2 = new Prijatelji(korisnik2, korisnik1);
		em.persist(prijatelji2);

		
		
		Restoran restoran1 = new Restoran(null, "Kavana ZIG", "Restoran domace punjene kuhinnje.", "Petrovica 44", "011/1452-680", 44.55, 45.1, null, null, null);
		em.persist(restoran1);
		korisnik4.setPoverenRestoran(restoran1);
		Restoran restoran2 = new Restoran(null, "Kurjak", "Janjetina vruca", "Vjeternik na glavnom putu 3", "011-4654-54", 4.55, 15.45, null, null, null);
		em.persist(restoran2);

		
		
		Jelo jelo1 = new Jelo("Mleko", "Iscedjeno", 11, restoran1);
		em.persist(jelo1);
		
		Jelo jelo2 = new Jelo("Boranija", "Iz menze", 72, restoran1);
		em.persist(jelo2);
		
		Jelo jelo3 = new Jelo("Kobaja", "Ide sa pasuljom u menzi", 72, restoran2);
		em.persist(jelo3);

		

		Sto sto1 = new Sto(1, restoran1, null);
		em.persist(sto1);		
		
		Sto sto2 = new Sto(2, restoran1, null);
		em.persist(sto2);	
		
		Sto sto3 = new Sto(1, restoran2, null);
		em.persist(sto3);		
		
		Sto sto4 = new Sto(4, restoran2, null);
		em.persist(sto4);		

		
		Rezervacija rezervacija1 = new Rezervacija(new Date(), 21, new Date(), 23, null, null);
		em.persist(rezervacija1);		
		Rezervacija rezervacija2 = new Rezervacija(new Date(), 19, new Date(), 20, null, null);
		em.persist(rezervacija2);		
		Rezervacija rezervacija3 = new Rezervacija(new Date(), 20, new Date(), 22, null, null);
		em.persist(rezervacija3);			
		
		
		RezervacijaSto rezervacijaSto1 = new RezervacijaSto(sto1, rezervacija1);
		em.persist(rezervacijaSto1);		
		RezervacijaSto rezervacijaSto2 = new RezervacijaSto(sto3, rezervacija2);
		em.persist(rezervacijaSto2);		
		RezervacijaSto rezervacijaSto3 = new RezervacijaSto(sto2, rezervacija3);
		em.persist(rezervacijaSto3);		
		RezervacijaSto rezervacijaSto4 = new RezervacijaSto(sto4, rezervacija3);
		em.persist(rezervacijaSto4);
		
		
		
		Poseta poseta1 = new Poseta(0, true, rezervacija1, korisnik1);
		em.persist(poseta1);		
		Poseta poseta2 = new Poseta(2, true, rezervacija1, korisnik2);
		em.persist(poseta2);		
		Poseta poseta3 = new Poseta(0, true, rezervacija2, korisnik2);
		em.persist(poseta3);		

		
	}
}
