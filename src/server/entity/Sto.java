package server.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "stolovi")
public class Sto implements Serializable {
	
	private static final long serialVersionUID = 5079837723899160251L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sto_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "broj_stola", unique = false, nullable = false)
	private Integer brojStola;
	
	@ManyToOne
	@JoinColumn(name = "maticni_restoran", referencedColumnName = "restoran_id", nullable = true)
	private Restoran maticniRestoran;
    
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "sto")
	private Set<RezervacijaSto> rezervacijeStolovi; 
	  
	@Version
	@Column(name="version", unique=false, nullable=false)
	private int version; 


	/// KONSTRUKTORI   *************************************
	    
	public Sto() {
		super();
	}

	public Sto(Integer brojStola, Restoran maticniRestoran, Set<RezervacijaSto> rezervacijeStolovi) {
		super();
		this.brojStola = brojStola;
		this.maticniRestoran = maticniRestoran;
		this.rezervacijeStolovi = rezervacijeStolovi;
	}


	/// GETERI I SETERI   *************************************
		
	public Integer getId() {
		return id;
	}

	public Integer getBrojStola() {
		return brojStola;
	}

	public Restoran getMaticniRestoran() {
		return maticniRestoran;
	}
	
	public Integer getVersion() {
		return version;
	}
	

	public Set<RezervacijaSto> getRezervacijeStolovi() {
		return rezervacijeStolovi;
	}

	public void setBrojStola(Integer brojStola) {
		this.brojStola = brojStola;
	}

	public void setMaticniRestoran(Restoran maticniRestoran) {
		this.maticniRestoran = maticniRestoran;
	}

	public void setRezervacijeStolovi(Set<RezervacijaSto> rezervacijeStolovi) {
		this.rezervacijeStolovi = rezervacijeStolovi;
	}

	public void addRezervacijaSto(RezervacijaSto rezervacijaSto) {
		if (this.rezervacijeStolovi == null)
			this.rezervacijeStolovi = new HashSet<RezervacijaSto>();
		this.rezervacijeStolovi.add(rezervacijaSto);
	}
}
