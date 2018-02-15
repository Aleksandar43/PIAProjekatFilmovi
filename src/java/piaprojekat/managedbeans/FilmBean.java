/* */
package piaprojekat.managedbeans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import piaprojekat.HibernateUtil;
import piaprojekat.entiteti.Film;

/**
 *
 * @author Aleksandar
 */
@ManagedBean
@RequestScoped
public class FilmBean {
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
        String idFilm = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idFilm");
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
        session.close();
        return "film";
    }
}
