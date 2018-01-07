/* */
package piaprojekat.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import piaprojekat.HibernateUtil;
import piaprojekat.entiteti.Korisnik;

/**
 *
 * @author Aleksandar
 */
@ManagedBean
@SessionScoped
public class KorisnikBean {
    private Korisnik korisnik;
    private String prijavaKorisnickoIme,prijavaLozinka;
    /**
     * Creates a new instance of SesijaBean
     */
    public KorisnikBean() {
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    
    public String getPrijavaKorisnickoIme() {
        return prijavaKorisnickoIme;
    }

    public void setPrijavaKorisnickoIme(String prijavaKorisnickoIme) {
        this.prijavaKorisnickoIme = prijavaKorisnickoIme;
    }

    public String getPrijavaLozinka() {
        return prijavaLozinka;
    }

    public void setPrijavaLozinka(String prijavaLozinka) {
        this.prijavaLozinka = prijavaLozinka;
    }

    public String prijava(){
        String adresa=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Object rez = session.getNamedQuery("Korisnik.findByKorisni\u010dkoIme").setParameter("korisni\u010dkoIme", prijavaKorisnickoIme).uniqueResult();
        if (rez!=null) {
            System.out.println("Pronađen korisnik " + rez);
            korisnik=(Korisnik)rez;
            adresa="loginTemp";
        } else {
            System.out.println("Nije pronađen korisnik \""+prijavaKorisnickoIme+"\"");
        }
        session.close();
        return adresa;
    }
}
