/* */
package piaprojekat.entiteti;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Aleksandar
 */
@Entity
@Table(name = "film")
@NamedQueries({
    @NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f")
    , @NamedQuery(name = "Film.findById", query = "SELECT f FROM Film f WHERE f.id = :id")
    , @NamedQuery(name = "Film.findByNazivSrpski", query = "SELECT f FROM Film f WHERE f.nazivSrpski = :nazivSrpski")
    , @NamedQuery(name = "Film.findByNazivOriginal", query = "SELECT f FROM Film f WHERE f.nazivOriginal = :nazivOriginal")
    , @NamedQuery(name = "Film.findByPoster", query = "SELECT f FROM Film f WHERE f.poster = :poster")
    , @NamedQuery(name = "Film.findByGodina", query = "SELECT f FROM Film f WHERE f.godina = :godina")
    , @NamedQuery(name = "Film.findByOpis", query = "SELECT f FROM Film f WHERE f.opis = :opis")
    , @NamedQuery(name = "Film.findByReditelj", query = "SELECT f FROM Film f WHERE f.reditelj = :reditelj")
    , @NamedQuery(name = "Film.findByGlavniGlumci", query = "SELECT f FROM Film f WHERE f.glavniGlumci = :glavniGlumci")
    , @NamedQuery(name = "Film.findByTrajanje", query = "SELECT f FROM Film f WHERE f.trajanje = :trajanje")
    , @NamedQuery(name = "Film.findByZemlja", query = "SELECT f FROM Film f WHERE f.zemlja = :zemlja")
    , @NamedQuery(name = "Film.findByLinkIMDB", query = "SELECT f FROM Film f WHERE f.linkIMDB = :linkIMDB")
    , @NamedQuery(name = "Film.findByLinkRT", query = "SELECT f FROM Film f WHERE f.linkRT = :linkRT")
    , @NamedQuery(name = "Film.findByLinkYoutube", query = "SELECT f FROM Film f WHERE f.linkYoutube = :linkYoutube")})
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nazivSrpski")
    private String nazivSrpski;
    @Basic(optional = false)
    @Column(name = "nazivOriginal")
    private String nazivOriginal;
    @Column(name = "poster")
    private String poster;
    @Column(name = "godina")
    private Integer godina;
    @Column(name = "opis")
    private String opis;
    @Column(name = "reditelj")
    private String reditelj;
    @Column(name = "glavniGlumci")
    private String glavniGlumci;
    @Column(name = "trajanje")
    private Integer trajanje;
    @Column(name = "zemlja")
    private String zemlja;
    @Column(name = "linkIMDB")
    private String linkIMDB;
    @Column(name = "linkRT")
    private String linkRT;
    @Column(name = "linkYoutube")
    private String linkYoutube;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFilma", fetch = FetchType.EAGER)
    private List<Slika> slikaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFilma")
    private List<Projekcija> projekcijaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFilma")
    private List<Ocena> ocenaList;

    public Film() {
    }

    public Film(Integer id) {
        this.id = id;
    }

    public Film(Integer id, String nazivSrpski, String nazivOriginal) {
        this.id = id;
        this.nazivSrpski = nazivSrpski;
        this.nazivOriginal = nazivOriginal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazivSrpski() {
        return nazivSrpski;
    }

    public void setNazivSrpski(String nazivSrpski) {
        this.nazivSrpski = nazivSrpski;
    }

    public String getNazivOriginal() {
        return nazivOriginal;
    }

    public void setNazivOriginal(String nazivOriginal) {
        this.nazivOriginal = nazivOriginal;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getGodina() {
        return godina;
    }

    public void setGodina(Integer godina) {
        this.godina = godina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getReditelj() {
        return reditelj;
    }

    public void setReditelj(String reditelj) {
        this.reditelj = reditelj;
    }

    public String getGlavniGlumci() {
        return glavniGlumci;
    }

    public void setGlavniGlumci(String glavniGlumci) {
        this.glavniGlumci = glavniGlumci;
    }

    public Integer getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Integer trajanje) {
        this.trajanje = trajanje;
    }

    public String getZemlja() {
        return zemlja;
    }

    public void setZemlja(String zemlja) {
        this.zemlja = zemlja;
    }

    public String getLinkIMDB() {
        return linkIMDB;
    }

    public void setLinkIMDB(String linkIMDB) {
        this.linkIMDB = linkIMDB;
    }

    public String getLinkRT() {
        return linkRT;
    }

    public void setLinkRT(String linkRT) {
        this.linkRT = linkRT;
    }

    public String getLinkYoutube() {
        return linkYoutube;
    }

    public void setLinkYoutube(String linkYoutube) {
        this.linkYoutube = linkYoutube;
    }

    public List<Slika> getSlikaList() {
        return slikaList;
    }

    public void setSlikaList(List<Slika> slikaList) {
        this.slikaList = slikaList;
    }

    public List<Projekcija> getProjekcijaList() {
        return projekcijaList;
    }

    public void setProjekcijaList(List<Projekcija> projekcijaList) {
        this.projekcijaList = projekcijaList;
    }

    public List<Ocena> getOcenaList() {
        return ocenaList;
    }

    public void setOcenaList(List<Ocena> ocenaList) {
        this.ocenaList = ocenaList;
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
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "piaprojekat.entiteti.Film[ id=" + id + " ]";
    }
    
}
