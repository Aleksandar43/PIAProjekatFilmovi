/* */
package piaprojekat.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import piaprojekat.HibernateUtil;
import piaprojekat.entiteti.Festival;
import piaprojekat.entiteti.Film;
import piaprojekat.entiteti.Projekcija;

@ManagedBean
@ViewScoped
public class PretragaBean implements Serializable{

    private String imeFestivala;
    private Date datumOd, datumDo;
    private List<Festival> listaFestivala = new ArrayList<>();
    private String originalniNazivFilma;
    private int tipPretrage=0;
    private List<Projekcija> listaProjekcijaFilma;

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

    public String getOriginalniNazivFilma() {
        return originalniNazivFilma;
    }

    public void setOriginalniNazivFilma(String originalniNazivFilma) {
        this.originalniNazivFilma = originalniNazivFilma;
    }

    public int getTipPretrage() {
        return tipPretrage;
    }

    public void setTipPretrage(int tipPretrage) {
        this.tipPretrage = tipPretrage;
    }

    public List<Projekcija> getListaProjekcijaFilma() {
        return listaProjekcijaFilma;
    }

    public void setListaProjekcijaFilma(List<Projekcija> listaProjekcijaFilma) {
        this.listaProjekcijaFilma = listaProjekcijaFilma;
    }

    public void pretragaNaslovna() {
        tipPretrage=1;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Festival> lista = session.getNamedQuery("Festival.findAll").list();
        listaFestivala = new ArrayList<>();
        for (Festival f : lista) {
            if (!f.getDatumKraja().before(Calendar.getInstance().getTime()) //za zadatak, malo čudno
                    && f.getNaziv().toLowerCase().contains(imeFestivala.toLowerCase())
                    && (datumOd == null || datumOd.before(f.getDatumPočetka()))
                    && (datumDo == null || datumDo.after(f.getDatumKraja()))) {
                listaFestivala.add(f);
            }
        }
        session.close();
    }

    /*Alternativno: ista funkcija sa čitanjem parametra*/
    
    public void pretragaFestivala() {
        tipPretrage=1;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Festival> lista = session.getNamedQuery("Festival.findAll").list();
        listaFestivala = new ArrayList<>();
        for (Festival f : lista) {
            if (f.getNaziv().toLowerCase().contains(imeFestivala.toLowerCase())
                    && (datumOd == null || datumOd.before(f.getDatumPočetka()))
                    && (datumDo == null || datumDo.after(f.getDatumKraja()))) {
                listaFestivala.add(f);
            }
        }
        session.close();
    }
    
    public void pretragaKodKorisnika() {
        if (originalniNazivFilma == null || originalniNazivFilma.equals("")) pretragaFestivala();
        else {
            tipPretrage=2;
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<Projekcija> lista;
            List<Film> filmovi = session.getNamedQuery("Film.findAll").list();
            listaProjekcijaFilma=new ArrayList<>();
            for (Film film : filmovi) {
                if (film.getNazivOriginal().toLowerCase().contains(originalniNazivFilma.toLowerCase())) {
                    lista = film.getProjekcijaList();
                    for (Projekcija p : lista) {
                        if(p.getIdFilma().getNazivOriginal().toLowerCase().contains(originalniNazivFilma.toLowerCase())
                                && p.getIdFestivala().getNaziv().toLowerCase().contains(imeFestivala.toLowerCase())
                                && (datumOd == null || datumOd.before(p.getIdFestivala().getDatumPočetka()))
                                && (datumDo == null || datumDo.after(p.getIdFestivala().getDatumKraja())))
                            listaProjekcijaFilma.add(p);
                    }
                }
            }
            session.close();
        }
    }
}
