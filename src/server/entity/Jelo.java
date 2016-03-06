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
@Table(name = "jela")
public class Jelo implements Serializable{
	
	private static final long serialVersionUID = 2581625911137752701L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "jelo_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "naziv", unique = true, nullable = false)
	private String naziv;

	@Column(name = "opis", unique = false, nullable = true)
	private String opis;

	@Column(name = "cena", unique = false, nullable = false)
	private Integer cena;
	
	@ManyToOne
	@JoinColumn(name = "restoran_sa_jelom", referencedColumnName = "restoran_id", nullable = false)
	private Restoran restoranSaJelom; 
	  
	@Version
	@Column(name="version", unique=false, nullable=false)
	private int version; 


	
/// KONSTRUKTORI   *************************************

	public Jelo() {
		super();
	}

	public Jelo(String naziv, String opis, Integer cena, Restoran restoranSaJelom) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.cena = cena;
		this.restoranSaJelom = restoranSaJelom;
	}		

/// GETERI I SETERI   *************************************

	public Integer getId() {
		return id;
	}
	
	public String getNaziv() {
		return naziv;
	}

	public String getOpis() {
		return opis;
	}

	public Integer getCena() {
		return cena;
	}

	public Restoran getRestoranSaJelom() {
		return restoranSaJelom;
	}
	
	public Integer getVersion() {
		return version;
	}
	

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public void setCena(Integer cena) {
		this.cena = cena;
	}
	
	public void setRestoranSaJelom(Restoran restoranSaJelom) {
		this.restoranSaJelom = restoranSaJelom;
	}
}
