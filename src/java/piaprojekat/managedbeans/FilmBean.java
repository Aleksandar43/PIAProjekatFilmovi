/* */
package piaprojekat.managedbeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import piaprojekat.HibernateUtil;
import piaprojekat.entiteti.Film;

/**
 *
 * @author Aleksandar
 */
@ManagedBean
@SessionScoped
public class FilmBean implements Serializable{
    private Film film;
    public FilmBean() {
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
    
    public String otvoriStranicuFilma(){
        String adresa=null;
        String idFilm = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idFilma");
        if(idFilm==null){
            //ERROR
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Neispravni podaci",null));
            return null;
        }
        int id = Integer.parseInt(idFilm);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        film = (Film) session.getNamedQuery("Film.findById").setParameter("id", id).uniqueResult();
        System.out.println("otvoriStranicuFilma(): film="+film);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("trenutniFilm", film);
        session.close();
        return "film";
    }
}
