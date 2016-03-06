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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "restorani")
public class Restoran implements Serializable {

	private static final long serialVersionUID = 4743406774280428582L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "restoran_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "slika", unique = false, nullable = true)
	private String slika;

	@Column(name = "naziv", unique = true, nullable = false)
	private String naziv;

	@Column(name = "opis", unique = false, nullable = false)
	private String opis;

	@Column(name = "adresa", unique = false, nullable = false)
	private String adresa;

	@Column(name = "kontakt", unique = false, nullable = false)
	private String kontakt;

	@Column(name = "lokacija_long", unique = false, nullable = true)
	private Double lokacijaLong;

	@Column(name = "lokacija_lat", unique = false, nullable = true)
	private Double lokacijaLat;
	

	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "restoranSaJelom")
	private Set<Jelo> jela;
    
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "poverenRestoran")
	private Set<KorisnikRestorana> rukovodioci;
    
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "maticniRestoran")
	private Set<Sto> stolovi; 
	  
	@Version
	@Column(name="version", unique=false, nullable=false)
	private int version; 


/// KONSTRUKTORI   *************************************
    
	public Restoran() {
		super();
	}

	public Restoran(String slika, String naziv, String opis, String adresa, String kontakt, Double lokacijaLong, 
			Double lokacijaLat, Set<Jelo> jela, Set<KorisnikRestorana> rukovodioci, Set<Sto> stolovi) {
		super();
		this.slika = slika;
		this.naziv = naziv;
		this.opis = opis;
		this.adresa = adresa;
		this.kontakt = kontakt;
		this.lokacijaLong = lokacijaLong;
		this.lokacijaLat = lokacijaLat;
		this.jela = jela;
		this.rukovodioci = rukovodioci;
		this.stolovi = stolovi;
	}


/// GETERI I SETERI   *************************************
	
	public Integer getId() {
		return id;
	}
	
	
	public String getSlika() {
		return slika;
	}
	
	
	public String getNaziv() {
		return naziv;
	}
	
	
	public String getOpis() {
		return opis;
	}
	
	
	public String getAdresa() {
		return adresa;
	}
	
	
	public String getKontakt() {
		return kontakt;
	}
	
	
	public Double getLokacijaLong() {
		return lokacijaLong;
	}
	
	
	public Double getLokacijaLat() {
		return lokacijaLat;
	}
	
	
	public Set<Jelo> getJela() {
		return jela;
	}
	
	
	public Set<KorisnikRestorana> getRukovodioci() {
		return rukovodioci;
	}
	
	
	public Set<Sto> getStolovi() {
		return stolovi;
	}
	
	
	public Integer getVersion() {
		return version;
	}
	
	
	
	public void setSlika(String slika) {
		this.slika = slika;
	}
	
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	
	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}
	
	
	public void setLokacijaLong(Double lokacijaLong) {
		this.lokacijaLong = lokacijaLong;
	}
	
	
	public void setLokacijaLat(Double lokacijaLat) {
		this.lokacijaLat = lokacijaLat;
	}
	
	
	public void setJela(Set<Jelo> jela) {
		this.jela = jela;
	}
	
	
	public void setRukovodioci(Set<KorisnikRestorana> rukovodioci) {
		this.rukovodioci = rukovodioci;
	}
	
	
	public void setStolovi(Set<Sto> stolovi) {
		this.stolovi = stolovi;
	}
	
	
	public void addJelo(Jelo jelo) {
		if (this.jela == null)
			this.jela = new HashSet<Jelo>();
		this.jela.add(jelo);
	}
	
	
	public void addRukovodilac(KorisnikRestorana rukovodilac) {
		if (this.rukovodioci == null)
			this.rukovodioci = new HashSet<KorisnikRestorana>();
		this.rukovodioci.add(rukovodilac);
	}
	
	
	public void addSto(Sto sto) {
		if (this.stolovi == null)
			this.stolovi = new HashSet<Sto>();
		this.stolovi.add(sto);
	}
	
}
