package server.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MS")
public class KorisnikSistema extends Korisnik implements Serializable {

	private static final long serialVersionUID = -5706857955118624990L;


/// KONSTRUKTORI   *************************************
	public KorisnikSistema() {
		super();
	}

	public KorisnikSistema(String slika, String ime, String prezime, String adresa, String email, String lozinka) {
		super(slika, ime, prezime, adresa, email, lozinka);
	}

/// GETERI I SETERI   *************************************

	
}
