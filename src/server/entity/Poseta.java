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
@Table(name = "posete")
public class Poseta implements Serializable {

	private static final long serialVersionUID = 7143691657967055800L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "poseta_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "ocena", unique = false, nullable = false)
	private Integer ocena;

	@Column(name = "poseta_prihvacena", unique = false, nullable = false)
	private Boolean posetaPrihvacena;
	
	@ManyToOne
	@JoinColumn(name = "rezervacija", referencedColumnName = "rezervacija_id", nullable = false)
	private Rezervacija rezervacija;
	
	@ManyToOne
	@JoinColumn(name = "posetilac", referencedColumnName = "korisnik_id", nullable = false)
	private KorisnikGost posetilac; 
	  
	@Version
	@Column(name="version", unique=false, nullable=false)
	private int version; 
	
	
	/// KONSTRUKTORI   *************************************
	
	public Poseta() {
		super();
	}

	public Poseta(Integer ocena, Boolean posetaPrihvacena, Rezervacija rezervacija, KorisnikGost posetilac) {
		super();
		this.ocena = ocena;
		this.posetaPrihvacena = posetaPrihvacena;
		this.rezervacija = rezervacija;
		this.posetilac = posetilac;
	}
	

	/// GETERI I SETERI   *************************************
	
	public Integer getId() {
		return id;
	}

	public Integer getOcena() {
		return ocena;
	}

	public Boolean getPosetaPrihvacena() {
		return posetaPrihvacena;
	}

	public Rezervacija getRezervacija() {
		return rezervacija;
	}

	public KorisnikGost getPosetilac() {
		return posetilac;
	}
	
	public Integer getVersion() {
		return version;
	}
	

	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}

	public void setPosetaPrihvacena(Boolean posetaPrihvacena) {
		this.posetaPrihvacena = posetaPrihvacena;
	}

	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}

	public void setPosetilac(KorisnikGost posetilac) {
		this.posetilac = posetilac;
	}
}
