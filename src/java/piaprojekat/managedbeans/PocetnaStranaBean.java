/* */
package piaprojekat.managedbeans;

import java.util.Arrays;
import javax.faces.application.FacesMessage;
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
    private Korisnik poljaZaRegistraciju=new Korisnik();
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
    
    public String promenaLozinke(){
        String adresa=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Object rez = session.getNamedQuery("Korisnik.findByKorisni\u010dkoIme").setParameter("korisni\u010dkoIme", promenaLozinkeKorisnickoIme).uniqueResult();
        if (rez!=null) {
            System.out.println("Pronađen korisnik " + rez);
            Korisnik korisnik=(Korisnik)rez;
            System.out.println(Arrays.toString(korisnik.getLozinka())+", "+Arrays.toString(promenaLozinkeStaraLozinka.getBytes()));
            if (Arrays.equals(korisnik.getLozinka(),promenaLozinkeStaraLozinka.getBytes())) {
                korisnik.setLozinka(promenaLozinkeNovaLozinka.getBytes());
                session.update(korisnik);
                session.getTransaction().commit();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspešno promenjena lozinka", "Uspešno promenjena lozinka"));
            } else {
                System.out.println("Pogrešna lozinka");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Neispravni podaci",null));
            }
        } else {
            System.out.println("Nije pronađen korisnik \""+promenaLozinkeKorisnickoIme+"\"");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Neispravni podaci",null));
        }
        session.close();
        return adresa;
    }
}
