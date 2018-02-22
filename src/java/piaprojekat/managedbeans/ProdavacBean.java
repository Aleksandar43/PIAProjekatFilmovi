/* */
package piaprojekat.managedbeans;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import piaprojekat.HibernateUtil;
import piaprojekat.entiteti.Festival;
import piaprojekat.entiteti.Film;
import piaprojekat.entiteti.Rezervacija;

/**
 *
 * @author Aleksandar
 */
@ManagedBean
@ViewScoped
public class ProdavacBean {

    private List<Rezervacija> listaRezervacija;
    private Rezervacija trenutnaRezervacija;

    public ProdavacBean() {
    }

    public List<Rezervacija> getRezervacije() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        listaRezervacija = session.getNamedQuery("Rezervacija.findAll").list();
        session.close();
        return listaRezervacija;
    }

    public List<Rezervacija> getListaRezervacija() {
        return listaRezervacija;
    }

    public void setListaRezervacija(List<Rezervacija> listaRezervacija) {
        this.listaRezervacija = listaRezervacija;
    }

    public Rezervacija getTrenutnaRezervacija() {
        return trenutnaRezervacija;
    }

    public void setTrenutnaRezervacija(Rezervacija trenutnaRezervacija) {
        this.trenutnaRezervacija = trenutnaRezervacija;
    }

    public void nadjiRezervaciju() {
        String idRezervacije = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idRezervacije");
        if (idRezervacije == null) {
            //ERROR
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Neispravni podaci",null));
        } else {
            int id = Integer.parseInt(idRezervacije);
            for(Rezervacija r:listaRezervacija){
                if(r.getId()==(id)){
                    trenutnaRezervacija=r;
                    break;
                }
            }
        }
    }
    
    public String placeno(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        trenutnaRezervacija.setKupljena(1);
        session.update(trenutnaRezervacija);
        session.getTransaction().commit();
        session.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Uplata uspešno registrovana",null));
        return null;
    }
}
