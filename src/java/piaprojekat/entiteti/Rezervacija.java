/* */
package piaprojekat.entiteti;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aleksandar
 */
@Entity
@Table(name = "rezervacija")
@NamedQueries({
    @NamedQuery(name = "Rezervacija.findAll", query = "SELECT r FROM Rezervacija r")
    , @NamedQuery(name = "Rezervacija.findById", query = "SELECT r FROM Rezervacija r WHERE r.id = :id")
    , @NamedQuery(name = "Rezervacija.findByKod", query = "SELECT r FROM Rezervacija r WHERE r.kod = :kod")
    , @NamedQuery(name = "Rezervacija.findByBrojUlaznica", query = "SELECT r FROM Rezervacija r WHERE r.brojUlaznica = :brojUlaznica")
    , @NamedQuery(name = "Rezervacija.findByVremeRezervacije", query = "SELECT r FROM Rezervacija r WHERE r.vremeRezervacije = :vremeRezervacije")
    , @NamedQuery(name = "Rezervacija.findByKupljena", query = "SELECT r FROM Rezervacija r WHERE r.kupljena = :kupljena")})
public class Rezervacija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "kod")
    private String kod;
    @Basic(optional = false)
    @Column(name = "brojUlaznica")
    private int brojUlaznica;
    @Basic(optional = false)
    @Column(name = "vremeRezervacije")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vremeRezervacije;
    @Basic(optional = false)
    @Column(name = "kupljena")
    private int kupljena;
    @JoinColumn(name = "korisnik", referencedColumnName = "korisni\u010dko_ime")
    @ManyToOne
    private Korisnik korisnik;
    @JoinColumn(name = "idProjekcije", referencedColumnName = "id")
    @ManyToOne
    private Projekcija idProjekcije;

    public Rezervacija() {
    }

    public Rezervacija(Integer id) {
        this.id = id;
    }

    public Rezervacija(Integer id, String kod, int brojUlaznica, Date vremeRezervacije, int kupljena) {
        this.id = id;
        this.kod = kod;
        this.brojUlaznica = brojUlaznica;
        this.vremeRezervacije = vremeRezervacije;
        this.kupljena = kupljena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public int getBrojUlaznica() {
        return brojUlaznica;
    }

    public void setBrojUlaznica(int brojUlaznica) {
        this.brojUlaznica = brojUlaznica;
    }

    public Date getVremeRezervacije() {
        return vremeRezervacije;
    }

    public void setVremeRezervacije(Date vremeRezervacije) {
        this.vremeRezervacije = vremeRezervacije;
    }

    public int getKupljena() {
        return kupljena;
    }

    public void setKupljena(int kupljena) {
        this.kupljena = kupljena;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Projekcija getIdProjekcije() {
        return idProjekcije;
    }

    public void setIdProjekcije(Projekcija idProjekcije) {
        this.idProjekcije = idProjekcije;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rezervacija)) {
            return false;
        }
        Rezervacija other = (Rezervacija) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "piaprojekat.entiteti.Rezervacija[ id=" + id + " ]";
    }
    
}
