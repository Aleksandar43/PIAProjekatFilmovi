/* */
package piaprojekat.managedbeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import piaprojekat.HibernateUtil;
import piaprojekat.entiteti.Festival;

@ManagedBean
@RequestScoped
public class PretragaBean {
    private String imeFestivala;
    private Date datumOd,datumDo;
    private List<Festival> listaFestivala=new ArrayList<>();
    public PretragaBean() {
    }

    public String getImeFestivala() {
        return imeFestivala;
    }

    public void setImeFestivala(String imeFestivala) {
        this.imeFestivala = imeFestivala;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public List<Festival> getListaFestivala() {
        return listaFestivala;
    }

    public void setListaFestivala(List<Festival> listaFestivala) {
        this.listaFestivala = listaFestivala;
    }
    
    public void pretraga(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Festival> lista = session.getNamedQuery("Festival.findAll").list();
        listaFestivala=new ArrayList<>();
        for(Festival f:lista){
            if(!f.getDatumKraja().before(Calendar.getInstance().getTime()) //za zadatak, malo čudno
                    && f.getNaziv().toLowerCase().contains(imeFestivala.toLowerCase())
                    && (datumOd==null || datumOd.before(f.getDatumPočetka()))
                    && (datumDo==null || datumDo.after(f.getDatumKraja()))) listaFestivala.add(f);
        }
        session.close();
    }
}
