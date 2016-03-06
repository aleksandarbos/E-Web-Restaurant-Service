package server.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("GR")
public class KorisnikGost extends Korisnik implements Serializable {

	private static final long serialVersionUID = -3910675229947775202L;
	
	@Column(name = "aktiviran", unique = false, nullable = true)
	private Boolean aktiviran;
    
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "osoba")
	private Set<Prijatelji> osoba;	
    
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "prijateljiSuMu")
	private Set<Prijatelji> prijateljiSuMu;	
    
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "posetilac")
	private Set<Poseta> posete;


	/// KONSTRUKTORI   *************************************
	
	public KorisnikGost() {
		super();
	}

	public KorisnikGost(String slika, String ime, String prezime, String adresa, String email, String lozinka, 
			Boolean aktiviran, Set<Prijatelji> prijateljiSuMu, Set<Prijatelji> osoba, Set<Poseta> posete) {
		super(slika, ime, prezime, adresa, email, lozinka);
		
		this.aktiviran = aktiviran;
		this.prijateljiSuMu = prijateljiSuMu;
		this.osoba = osoba;
		this.posete = posete;
	}

	
	/// GETERI I SETERI   *************************************
	
	public Boolean getAktiviran() {
		return aktiviran;
	}

	public Set<Prijatelji> getPrijateljiSuMu() {
		return prijateljiSuMu;
	}

	public Set<Prijatelji> getOsoba() {
		return osoba;
	}

	public Set<Poseta> getPosete() {
		return posete;
	}

	
	public void setAktiviran(Boolean aktiviran) {
		this.aktiviran = aktiviran;
	}

	public void setPrijateljiSuMu(Set<Prijatelji> prijateljiSuMu) {
		this.prijateljiSuMu = prijateljiSuMu;
	}
	
	public void setOsoba(Set<Prijatelji> osoba) {
		this.osoba = osoba;
	}	
	
	public void setPosete(Set<Poseta> posete) {
		this.posete = posete;
	}	
	
	public void addPrijateljiMuJe(Prijatelji osoba) {
		if (this.osoba == null)
			this.osoba = new HashSet<Prijatelji>();
		this.osoba.add(osoba);
	}	
	
	public void addPoseta(Poseta poseta) {
		if (this.posete == null)
			this.posete = new HashSet<Poseta>();
		this.posete.add(poseta);
	}	
}
