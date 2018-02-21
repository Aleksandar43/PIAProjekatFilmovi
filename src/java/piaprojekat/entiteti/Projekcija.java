/* */
package piaprojekat.entiteti;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aleksandar
 */
@Entity
@Table(name = "projekcija")
@NamedQueries({
    @NamedQuery(name = "Projekcija.findAll", query = "SELECT p FROM Projekcija p")
    , @NamedQuery(name = "Projekcija.findById", query = "SELECT p FROM Projekcija p WHERE p.id = :id")
    , @NamedQuery(name = "Projekcija.findByVreme", query = "SELECT p FROM Projekcija p WHERE p.vreme = :vreme")
    , @NamedQuery(name = "Projekcija.findByOtkazana", query = "SELECT p FROM Projekcija p WHERE p.otkazana = :otkazana")})
public class Projekcija implements Serializable {

    @Basic(optional = false)
    @Column(name = "cena")
    private int cena;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "vreme")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vreme;
    @Basic(optional = false)
    @Column(name = "otkazana")
    private int otkazana;
    @OneToMany(mappedBy = "idProjekcije")
    private List<Rezervacija> rezervacijaList;
    @JoinColumn(name = "idFestivala", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Festival idFestivala;
    @JoinColumn(name = "idFilma", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Film idFilma;
    @JoinColumn(name = "idLokacije", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lokacija idLokacije;

    public Projekcija() {
    }

    public Projekcija(Integer id) {
        this.id = id;
    }

    public Projekcija(Integer id, Date vreme, int otkazana) {
        this.id = id;
        this.vreme = vreme;
        this.otkazana = otkazana;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getVreme() {
        return vreme;
    }

    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }

    public int getOtkazana() {
        return otkazana;
    }

    public void setOtkazana(int otkazana) {
        this.otkazana = otkazana;
    }

    public List<Rezervacija> getRezervacijaList() {
        return rezervacijaList;
    }

    public void setRezervacijaList(List<Rezervacija> rezervacijaList) {
        this.rezervacijaList = rezervacijaList;
    }

    public Festival getIdFestivala() {
        return idFestivala;
    }

    public void setIdFestivala(Festival idFestivala) {
        this.idFestivala = idFestivala;
    }

    public Film getIdFilma() {
        return idFilma;
    }

    public void setIdFilma(Film idFilma) {
        this.idFilma = idFilma;
    }

    public Lokacija getIdLokacije() {
        return idLokacije;
    }

    public void setIdLokacije(Lokacija idLokacije) {
        this.idLokacije = idLokacije;
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
        if (!(object instanceof Projekcija)) {
            return false;
        }
        Projekcija other = (Projekcija) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String vremeFormatirano = new SimpleDateFormat("dd.MM.yyyy. hh:mm").format(vreme);
        return idFestivala.getNaziv()+", "+vremeFormatirano;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
    
}
