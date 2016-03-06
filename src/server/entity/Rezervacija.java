package server.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "rezervacije")
public class Rezervacija implements Serializable {

	private static final long serialVersionUID = 4045719169867086347L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "rezervacija_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "pocetak_datum", unique = false, nullable = false)
	private Date pocetakDatum;

	@Column(name = "pocetak_sat", unique = false, nullable = false)
	private Integer pocetakSat;

	@Column(name = "kraj_datum", unique = false, nullable = false)
	private Date krajDatum;

	@Column(name = "kraj_sat", unique = false, nullable = false)
	private Integer krajSat;
    
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "rezervacija")
	private Set<RezervacijaSto> rezervacijeStolovi;	
    
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "rezervacija")
	private Set<Poseta> posete; 
	  
	@Version
	@Column(name="version", unique=false, nullable=false)
	private int version; 

	
	/// KONSTRUKTORI   *************************************
	
	public Rezervacija() {
		super();
	}


	public Rezervacija(Date pocetakDatum, Integer pocetakSat, Date krajDatum, Integer krajSat, 
			Set<RezervacijaSto> rezervacijeStolovi, Set<Poseta> posete) {
		super();
		this.pocetakDatum = pocetakDatum;
		this.pocetakSat = pocetakSat;
		this.krajDatum = krajDatum;
		this.krajSat = krajSat;
		this.rezervacijeStolovi = rezervacijeStolovi;
		this.posete = posete;
	}
	

	/// GETERI I SETERI   *************************************
	
	public Integer getId() {
		return id;
	}

	public Date getPocetakDatum() {
		return pocetakDatum;
	}

	public Integer getPocetakSat() {
		return pocetakSat;
	}

	public Date getKrajDatum() {
		return krajDatum;
	}

	public Integer getKrajSat() {
		return krajSat;
	}

	public Set<RezervacijaSto> getRezervacijeStolovi() {
		return rezervacijeStolovi;
	}

	public Set<Poseta> getPosete() {
		return posete;
	}
	
	public Integer getVersion() {
		return version;
	}
	

	public void setPocetakDatum(Date pocetakDatum) {
		this.pocetakDatum = pocetakDatum;
	}

	public void setPocetakSat(Integer pocetakSat) {
		this.pocetakSat = pocetakSat;
	}

	public void setKrajDatum(Date krajDatum) {
		this.krajDatum = krajDatum;
	}

	public void setKrajSat(Integer krajSat) {
		this.krajSat = krajSat;
	}

	public void setRezervacijeStolovi(Set<RezervacijaSto> rezervacijeStolovi) {
		this.rezervacijeStolovi = rezervacijeStolovi;
	}

	public void setPosete(Set<Poseta> posete) {
		this.posete = posete;
	}	

	public void addPoseta(Poseta poseta) {
		if (this.posete == null)
			this.posete = new HashSet<Poseta>();
		this.posete.add(poseta);
	}	

	public void addRezervacijaSto(RezervacijaSto rezervacijaSto) {
		if (this.rezervacijeStolovi == null)
			this.rezervacijeStolovi = new HashSet<RezervacijaSto>();
		this.rezervacijeStolovi.add(rezervacijaSto);
	}
}
