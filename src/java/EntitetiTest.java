
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import piaprojekat.HibernateUtil;
import piaprojekat.entiteti.*;

/* */
/**
 *
 * @author Aleksandar
 */
@ManagedBean
@ApplicationScoped
public class EntitetiTest {
    private int brojPoziva1=0,brojPoziva2=0;
    public List listaKorisnika(){
        brojPoziva1++;
        System.out.println("lista 1 "+brojPoziva1+". put");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Korisnik> resultList = session.createQuery("from Korisnik k")
                .list();
//        for(Object o:resultList)
//            System.out.println(o);
        session.close();
        return resultList;
    }
    public List listaKorisnika2(){
        brojPoziva2++;
        System.out.println("lista 2 "+brojPoziva2+". put");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Korisnik> resultList = session.getNamedQuery("Korisnik.findAll").list();
//        System.out.println("listaKorisnika2: ----------------------");
//        for(Object o:resultList)
//            System.out.println(o);
        session.close();
        return resultList;
    }
}
