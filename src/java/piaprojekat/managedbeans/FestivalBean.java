/* */
package piaprojekat.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import piaprojekat.HibernateUtil;
import piaprojekat.entiteti.Festival;

/**
 *
 * @author Aleksandar
 */
@ManagedBean
@RequestScoped
public class FestivalBean {
    private Festival festival;
    public FestivalBean() {
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }
    
    public String otvoriStranicuFestivala(){
        String adresa=null;
        String idFestival = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idFestival");
        if(idFestival==null){
            //ERROR
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Neispravni podaci",null));
            return null;
        }
        int id = Integer.parseInt(idFestival);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        festival = (Festival) session.getNamedQuery("Festival.findById").setParameter("id", id).uniqueResult();
        session.close();
        return "festival";
    }
}
