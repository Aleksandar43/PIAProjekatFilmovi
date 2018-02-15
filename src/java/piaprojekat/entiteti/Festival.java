/* */
package piaprojekat.entiteti;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "festival")
@NamedQueries({
    @NamedQuery(name = "Festival.findAll", query = "SELECT f FROM Festival f")
    , @NamedQuery(name = "Festival.findById", query = "SELECT f FROM Festival f WHERE f.id = :id")
    , @NamedQuery(name = "Festival.findByNaziv", query = "SELECT f FROM Festival f WHERE f.naziv = :naziv")
    , @NamedQuery(name = "Festival.findByDatumPo\u010detka", query = "SELECT f FROM Festival f WHERE f.datumPo\u010detka = :datumPo\u010detka")
    , @NamedQuery(name = "Festival.findByDatumKraja", query = "SELECT f FROM Festival f WHERE f.datumKraja = :datumKraja")
    , @NamedQuery(name = "Festival.findByOpis", query = "SELECT f FROM Festival f WHERE f.opis = :opis")
    , @NamedQuery(name = "Festival.findByGrad", query = "SELECT f FROM Festival f WHERE f.grad = :grad")
    , @NamedQuery(name = "Festival.findByMaksUlaznicaPoKorisniku", query = "SELECT f FROM Festival f WHERE f.maksUlaznicaPoKorisniku = :maksUlaznicaPoKorisniku")})
public class Festival implements Serializable {

    @JoinTable(name = "festivalilokacije", joinColumns = {
        @JoinColumn(name = "idFestivala", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "idLokacije", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Lokacija> lokacijaCollection;

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
    @Column(name = "datumPo\u010detka")
    @Temporal(TemporalType.DATE)
    private Date datumPočetka;
    @Basic(optional = false)
    @Column(name = "datumKraja")
    @Temporal(TemporalType.DATE)
    private Date datumKraja;
    @Column(name = "opis")
    private String opis;
    @Basic(optional = false)
    @Column(name = "grad")
    private String grad;
    @Basic(optional = false)
    @Column(name = "maksUlaznicaPoKorisniku")
    private int maksUlaznicaPoKorisniku;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFestivala")
    private List<Projekcija> projekcijaList;

    public Festival() {
    }

    public Festival(Integer id) {
        this.id = id;
    }

    public Festival(Integer id, String naziv, Date datumPočetka, Date datumKraja, String grad, int maksUlaznicaPoKorisniku) {
        this.id = id;
        this.naziv = naziv;
        this.datumPočetka = datumPočetka;
        this.datumKraja = datumKraja;
        this.grad = grad;
        this.maksUlaznicaPoKorisniku = maksUlaznicaPoKorisniku;
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

    public Date getDatumPočetka() {
        return datumPočetka;
    }

    public void setDatumPočetka(Date datumPočetka) {
        this.datumPočetka = datumPočetka;
    }

    public Date getDatumKraja() {
        return datumKraja;
    }

    public void setDatumKraja(Date datumKraja) {
        this.datumKraja = datumKraja;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getMaksUlaznicaPoKorisniku() {
        return maksUlaznicaPoKorisniku;
    }

    public void setMaksUlaznicaPoKorisniku(int maksUlaznicaPoKorisniku) {
        this.maksUlaznicaPoKorisniku = maksUlaznicaPoKorisniku;
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
        if (!(object instanceof Festival)) {
            return false;
        }
        Festival other = (Festival) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "piaprojekat.entiteti.Festival[ id=" + id + " ]";
    }

    public Collection<Lokacija> getLokacijaCollection() {
        return lokacijaCollection;
    }

    public void setLokacijaCollection(Collection<Lokacija> lokacijaCollection) {
        this.lokacijaCollection = lokacijaCollection;
    }
    
}
