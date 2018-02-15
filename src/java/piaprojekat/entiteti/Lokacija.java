/* */
package piaprojekat.entiteti;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Aleksandar
 */
@Entity
@Table(name = "lokacija")
@NamedQueries({
    @NamedQuery(name = "Lokacija.findAll", query = "SELECT l FROM Lokacija l")
    , @NamedQuery(name = "Lokacija.findById", query = "SELECT l FROM Lokacija l WHERE l.id = :id")
    , @NamedQuery(name = "Lokacija.findByNaziv", query = "SELECT l FROM Lokacija l WHERE l.naziv = :naziv")
    , @NamedQuery(name = "Lokacija.findByGrad", query = "SELECT l FROM Lokacija l WHERE l.grad = :grad")})
public class Lokacija implements Serializable {

    @ManyToMany(mappedBy = "lokacijaCollection")
    private Collection<Festival> festivalCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @Column(name = "grad")
    private String grad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLokacije")
    private List<Projekcija> projekcijaList;

    public Lokacija() {
    }

    public Lokacija(Integer id) {
        this.id = id;
    }

    public Lokacija(Integer id, String naziv, String grad) {
        this.id = id;
        this.naziv = naziv;
        this.grad = grad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public List<Projekcija> getProjekcijaList() {
        return projekcijaList;
    }

    public void setProjekcijaList(List<Projekcija> projekcijaList) {
        this.projekcijaList = projekcijaList;
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
        if (!(object instanceof Lokacija)) {
            return false;
        }
        Lokacija other = (Lokacija) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "piaprojekat.entiteti.Lokacija[ id=" + id + " ]";
    }

    public Collection<Festival> getFestivalCollection() {
        return festivalCollection;
    }

    public void setFestivalCollection(Collection<Festival> festivalCollection) {
        this.festivalCollection = festivalCollection;
    }
    
}
