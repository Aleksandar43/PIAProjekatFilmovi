/* */
package piaprojekat.entiteti;

import java.io.Serializable;
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

/**
 *
 * @author Aleksandar
 */
@Entity
@Table(name = "ocena")
@NamedQueries({
    @NamedQuery(name = "Ocena.findAll", query = "SELECT o FROM Ocena o")
    , @NamedQuery(name = "Ocena.findById", query = "SELECT o FROM Ocena o WHERE o.id = :id")
    , @NamedQuery(name = "Ocena.findByVrednost", query = "SELECT o FROM Ocena o WHERE o.vrednost = :vrednost")
    , @NamedQuery(name = "Ocena.findByKomentar", query = "SELECT o FROM Ocena o WHERE o.komentar = :komentar")})
public class Ocena implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "vrednost")
    private int vrednost;
    @Column(name = "komentar")
    private String komentar;
    @JoinColumn(name = "idFilma", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Film idFilma;
    @JoinColumn(name = "korisnik", referencedColumnName = "korisni\u010dko_ime")
    @ManyToOne
    private Korisnik korisnik;

    public Ocena() {
    }

    public Ocena(Integer id) {
        this.id = id;
    }

    public Ocena(Integer id, int vrednost) {
        this.id = id;
        this.vrednost = vrednost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVrednost() {
        return vrednost;
    }

    public void setVrednost(int vrednost) {
        this.vrednost = vrednost;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public Film getIdFilma() {
        return idFilma;
    }

    public void setIdFilma(Film idFilma) {
        this.idFilma = idFilma;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
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
        if (!(object instanceof Ocena)) {
            return false;
        }
        Ocena other = (Ocena) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "piaprojekat.entiteti.Ocena[ id=" + id + " ]";
    }
    
}
