/* */
package piaprojekat.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import piaprojekat.HibernateUtil;
import piaprojekat.entiteti.Korisnik;

/**
 *
 * @author Aleksandar
 */
@ManagedBean
@RequestScoped
public class PocetnaStranaBean {
    private Korisnik poljaZaRegistraciju;
    private String promenaLozinkeKorisnickoIme,promenaLozinkeStaraLozinka,promenaLozinkeNovaLozinka;
    /**
     * Creates a new instance of PocetnaStranaBean
     */
    public PocetnaStranaBean() {
    }

    public Korisnik getPoljaZaRegistraciju() {
        return poljaZaRegistraciju;
    }

    public void setPoljaZaRegistraciju(Korisnik poljaZaRegistraciju) {
        this.poljaZaRegistraciju = poljaZaRegistraciju;
    }

    public String getPromenaLozinkeKorisnickoIme() {
        return promenaLozinkeKorisnickoIme;
    }

    public void setPromenaLozinkeKorisnickoIme(String promenaLozinkeKorisnickoIme) {
        this.promenaLozinkeKorisnickoIme = promenaLozinkeKorisnickoIme;
    }

    public String getPromenaLozinkeStaraLozinka() {
        return promenaLozinkeStaraLozinka;
    }

    public void setPromenaLozinkeStaraLozinka(String promenaLozinkeStaraLozinka) {
        this.promenaLozinkeStaraLozinka = promenaLozinkeStaraLozinka;
    }

    public String getPromenaLozinkeNovaLozinka() {
        return promenaLozinkeNovaLozinka;
    }

    public void setPromenaLozinkeNovaLozinka(String promenaLozinkeNovaLozinka) {
        this.promenaLozinkeNovaLozinka = promenaLozinkeNovaLozinka;
    }
    
}
