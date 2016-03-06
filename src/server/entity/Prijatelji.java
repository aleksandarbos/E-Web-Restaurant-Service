package server.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "prijatelji")
public class Prijatelji implements Serializable {

	private static final long serialVersionUID = -8361872163165599701L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "prijateljstvo_id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "osoba", referencedColumnName = "korisnik_id", nullable = false)
	private KorisnikGost osoba;
	
	@ManyToOne
	@JoinColumn(name = "prijatelji_su_mu", referencedColumnName = "korisnik_id", nullable = false)
	private KorisnikGost prijateljiSuMu; 
	  
	@Version
	@Column(name="version", unique=false, nullable=false)
	private int version; 
	

	/// KONSTRUKTORI   *************************************

	public Prijatelji() {
		super();
	}
	
	public Prijatelji(KorisnikGost osoba, KorisnikGost prijateljiSuMu) {
		super();
		this.osoba = osoba;
		this.prijateljiSuMu = prijateljiSuMu;
	}

	
	/// GETERI I SETERI   *************************************
	
	public Integer getId() {
		return id;
	}

	public KorisnikGost getOsoba() {
		return osoba;
	}

	public KorisnikGost getPrijateljiSuMu() {
		return prijateljiSuMu;
	}
	
	public Integer getVersion() {
		return version;
	}
	

	public void setOsoba(KorisnikGost osoba) {
		this.osoba = osoba;
	}

	public void setPrijateljiSuMu(KorisnikGost prijateljiSuMu) {
		this.prijateljiSuMu = prijateljiSuMu;
	}
}
