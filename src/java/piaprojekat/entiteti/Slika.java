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
@Table(name = "slika")
@NamedQueries({
    @NamedQuery(name = "Slika.findAll", query = "SELECT s FROM Slika s")
    , @NamedQuery(name = "Slika.findById", query = "SELECT s FROM Slika s WHERE s.id = :id")
    , @NamedQuery(name = "Slika.findByPutanja", query = "SELECT s FROM Slika s WHERE s.putanja = :putanja")})
public class Slika implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "putanja")
    private String putanja;
    @JoinColumn(name = "idFilma", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Film idFilma;

    public Slika() {
    }

    public Slika(Integer id) {
        this.id = id;
    }

    public Slika(Integer id, String putanja) {
        this.id = id;
        this.putanja = putanja;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPutanja() {
        return putanja;
    }

    public void setPutanja(String putanja) {
        this.putanja = putanja;
    }

    public Film getIdFilma() {
        return idFilma;
    }

    public void setIdFilma(Film idFilma) {
        this.idFilma = idFilma;
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
        if (!(object instanceof Slika)) {
            return false;
        }
        Slika other = (Slika) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "piaprojekat.entiteti.Slika[ id=" + id + " ]";
    }
    
}
