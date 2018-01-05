/* */
package piaprojekat.entiteti;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Aleksandar
 */
@Entity
@Table(name = "korisnik")
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k")
    , @NamedQuery(name = "Korisnik.findByKorisni\u010dkoIme", query = "SELECT k FROM Korisnik k WHERE k.korisni\u010dkoIme = :korisni\u010dkoIme")
    , @NamedQuery(name = "Korisnik.findByIme", query = "SELECT k FROM Korisnik k WHERE k.ime = :ime")
    , @NamedQuery(name = "Korisnik.findByPrezime", query = "SELECT k FROM Korisnik k WHERE k.prezime = :prezime")
    , @NamedQuery(name = "Korisnik.findByTelefon", query = "SELECT k FROM Korisnik k WHERE k.telefon = :telefon")
    , @NamedQuery(name = "Korisnik.findByEMail", query = "SELECT k FROM Korisnik k WHERE k.eMail = :eMail")
    , @NamedQuery(name = "Korisnik.findByTip", query = "SELECT k FROM Korisnik k WHERE k.tip = :tip")
    , @NamedQuery(name = "Korisnik.findByOdobren", query = "SELECT k FROM Korisnik k WHERE k.odobren = :odobren")})
public class Korisnik implements Serializable {

    @Basic(optional = false)
    @Lob
    @Column(name = "lozinka")
    private byte[] lozinka;
    @OneToMany(mappedBy = "korisnik")
    private List<Rezervacija> rezervacijaList;
    @OneToMany(mappedBy = "korisnik")
    private List<Ocena> ocenaList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "korisni\u010dko_ime")
    private String korisničkoIme;
    @Basic(optional = false)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @Column(name = "prezime")
    private String prezime;
    @Column(name = "telefon")
    private String telefon;
    @Basic(optional = false)
    @Column(name = "`e-mail`")
    private String eMail;
    @Basic(optional = false)
    @Column(name = "tip")
    private String tip;
    @Basic(optional = false)
    @Column(name = "odobren")
    private int odobren;

    public Korisnik() {
    }

    public Korisnik(String korisničkoIme) {
        this.korisničkoIme = korisničkoIme;
    }

    public Korisnik(String korisničkoIme, byte[] lozinka, String ime, String prezime, String eMail, String tip, int odobren) {
        this.korisničkoIme = korisničkoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.eMail = eMail;
        this.tip = tip;
        this.odobren = odobren;
    }

    public String getKorisničkoIme() {
        return korisničkoIme;
    }

    public void setKorisničkoIme(String korisničkoIme) {
        this.korisničkoIme = korisničkoIme;
    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getOdobren() {
        return odobren;
    }

    public void setOdobren(int odobren) {
        this.odobren = odobren;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korisničkoIme != null ? korisničkoIme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.korisničkoIme == null && other.korisničkoIme != null) || (this.korisničkoIme != null && !this.korisničkoIme.equals(other.korisničkoIme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "piaprojekat.entiteti.Korisnik[ korisni\u010dkoIme=" + korisničkoIme + " ]";
    }

    public byte[] getLozinka() {
        return lozinka;
    }

    public void setLozinka(byte[] lozinka) {
        this.lozinka = lozinka;
    }

    public List<Rezervacija> getRezervacijaList() {
        return rezervacijaList;
    }

    public void setRezervacijaList(List<Rezervacija> rezervacijaList) {
        this.rezervacijaList = rezervacijaList;
    }

    public List<Ocena> getOcenaList() {
        return ocenaList;
    }

    public void setOcenaList(List<Ocena> ocenaList) {
        this.ocenaList = ocenaList;
    }
    
}
