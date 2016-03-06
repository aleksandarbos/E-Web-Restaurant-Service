package server.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("MR")
public class KorisnikRestorana extends Korisnik implements Serializable {

	private static final long serialVersionUID = 8827466289490347080L;	

	@ManyToOne
	@JoinColumn(name = "poveren_restoran", referencedColumnName = "restoran_id", nullable = true)
	private Restoran poverenRestoran;	    


/// KONSTRUKTORI   *************************************
	
	public KorisnikRestorana() {
		super();
	}

	public KorisnikRestorana(String slika, String ime, String prezime, String adresa, String email, String lozinka, Restoran poverenRestoran) {
		super(slika, ime, prezime, adresa, email, lozinka);
		this.poverenRestoran = poverenRestoran;
	}
	

/// GETERI I SETERI   *************************************

	public Restoran getPoverenRestoran() {
		return poverenRestoran;
	}


	public void setPoverenRestoran(Restoran poverenRestoran) {
		this.poverenRestoran = poverenRestoran;
	}

}
