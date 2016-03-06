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
@Table(name = "rezervacija_sto")
public class RezervacijaSto implements Serializable {

	private static final long serialVersionUID = -8284952078367625233L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "rezervacijasto_id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "sto", referencedColumnName = "sto_id", nullable = false)
	private Sto sto;
	
	@ManyToOne
	@JoinColumn(name = "rezervacija", referencedColumnName = "rezervacija_id", nullable = false)
	private Rezervacija rezervacija; 
	  
	@Version
	@Column(name="version", unique=false, nullable=false)
	private int version; 
	

	/// KONSTRUKTORI   *************************************
	
	public RezervacijaSto() {
		super();
	}

	public RezervacijaSto(Sto sto, Rezervacija rezervacija) {
		super();
		this.sto = sto;
		this.rezervacija = rezervacija;
	}

	
	/// GETERI I SETERI   *************************************
	
	public Integer getId() {
		return id;
	}

	public Sto getSto() {
		return sto;
	}

	public Rezervacija getRezervacija() {
		return rezervacija;
	}
	
	public Integer getVersion() {
		return version;
	}
	

	public void setSto(Sto sto) {
		this.sto = sto;
	}

	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}
}
