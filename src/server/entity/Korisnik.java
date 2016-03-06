package server.entity;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "korisnici")
@Inheritance(strategy=SINGLE_TABLE)
@DiscriminatorColumn(name="tip", discriminatorType=STRING)
public abstract class Korisnik implements Serializable {

	private static final long serialVersionUID = -4557207777296639183L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "korisnik_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "slika", unique = false, nullable = true)
	private String slika;

	@Column(name = "ime", unique = false, nullable = false)
	private String ime;

	@Column(name = "prezime", unique = false, nullable = false)
	private String prezime;

	@Column(name = "adresa", unique = false, nullable = true)
	private String adresa;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "lozinka", unique = false, nullable = false)
	private String lozinka; 

	@Column(name = "tip", unique = false, nullable = false)
	private String tip;  
	  
	@Version
	@Column(name="version", unique=false, nullable=false)
	private int version; 


/// KONSTRUKTORI   *************************************
	public Korisnik() {
		super();
	}

	public Korisnik(String slika, String ime, String prezime, String adresa, String email, String lozinka) {
		super();
		this.slika = slika;
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		this.email = email;
		this.lozinka = lozinka;
	}

/// GETERI I SETERI   *************************************
	public Integer getId() {
		return id;
	}

	public String getSlika() {
		return slika;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getAdresa() {
		return adresa;
	}

	public String getEmail() {
		return email;
	}

	public String getLozinka() {
		return lozinka;
	}
	
	public Integer getVersion() {
		return version;
	}
	
	public String getTip() {
		return tip;
	}
	
	
	public void setSlika(String slika) {
		this.slika = slika;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}	
}
