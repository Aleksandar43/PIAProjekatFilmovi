/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piaprojekat.managedbeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import piaprojekat.HibernateUtil;
import piaprojekat.entiteti.Film;
import piaprojekat.entiteti.Korisnik;
import piaprojekat.entiteti.Projekcija;
import piaprojekat.entiteti.Rezervacija;

/**
 *
 * @author Aleksandar
 */
@ManagedBean
@ViewScoped
public class RezervacijaBean implements Serializable{
    private int maksBrojUlaznica=20;
    private Projekcija projekcija=null;
    private int idProjekcije=0;
    private int brojUlaznicaZaProjekciju=0; //!!!
    private boolean vidljivostForme;
    private List<Integer> brojUlaznica;
    private String kod;
    private Date vremeRezervacije=new Date();
    public RezervacijaBean() {
    }

    public int getMaksBrojUlaznica() {
        return maksBrojUlaznica;
    }

    public void setMaksBrojUlaznica(int maksBrojUlaznica) {
        this.maksBrojUlaznica = maksBrojUlaznica;
        System.out.println("maksBrojUlaznica="+maksBrojUlaznica);
    }

    public Projekcija getProjekcija() {
        return projekcija;
    }

    public void setProjekcija(Projekcija projekcija) {
        this.projekcija = projekcija;
        System.out.println("projekcija="+projekcija);
    }

    public int getIdProjekcije() {
        return idProjekcije;
    }

    public void setIdProjekcije(int idProjekcije) {
        this.idProjekcije = idProjekcije;
        System.out.println("idProjekcije="+idProjekcije);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        projekcija = (Projekcija) session.getNamedQuery("Projekcija.findById").setParameter("id", idProjekcije).uniqueResult();
        session.close();
        maksBrojUlaznica=projekcija.getIdFestivala().getMaksUlaznicaPoKorisniku();
    }

    public List<Integer> getBrojUlaznica() {
        return brojUlaznica;
    }

    public void setBrojUlaznica(List<Integer> brojUlaznica) {
        this.brojUlaznica = brojUlaznica;
    }
    
    public void promeniBrojUlaznica(){
        System.out.println("fs;lfksd;lfsdkfls;dfjsdlfkdsjfslkd;fjdsl;fsjdfl;kdsjfs;ldfkjsdlf;sjkdfl;sdfjsdkl;fjsdl");
        brojUlaznica=new ArrayList<>();
        for(int i=0;i<maksBrojUlaznica;i++) brojUlaznica.add(i+1);
        maksBrojUlaznica=projekcija.getIdFestivala().getMaksUlaznicaPoKorisniku();
        System.out.println("maksBrojUlaznica="+maksBrojUlaznica);
    }

    public int getBrojUlaznicaZaProjekciju() {
        return brojUlaznicaZaProjekciju;
    }

    public void setBrojUlaznicaZaProjekciju(int brojUlaznicaZaProjekciju) {
        this.brojUlaznicaZaProjekciju = brojUlaznicaZaProjekciju;
        System.out.println("brojUlaznicaZaProjekciju="+brojUlaznicaZaProjekciju);
    }

    public boolean isVidljivostForme() {
        return vidljivostForme;
    }

    public void setVidljivostForme(boolean vidljivostForme) {
        this.vidljivostForme = vidljivostForme;
    }
    
    public List<Integer> getBrUl(){
        List<Integer> x=new ArrayList<>();
        for(int i=0;i<maksBrojUlaznica;i++) x.add(i+1);
        return x;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public Date getVremeRezervacije() {
        return vremeRezervacije;
    }

    public void setVremeRezervacije(Date vremeRezervacije) {
        this.vremeRezervacije = vremeRezervacije;
    }
    
    public String getVremeRezervacijeFormatirano() {
        return new SimpleDateFormat("dd.MM.yyyy. hh:mm").format(vremeRezervacije);
    }

    public List<Projekcija> getSveProjekcije(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Projekcija> lista,lista2=new ArrayList<>();
        Film film = (Film) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("trenutniFilm");
        lista=session.getNamedQuery("Projekcija.findAll").list();
        for(Projekcija p:lista){
            if(Objects.equals(p.getIdFilma().getId(), film.getId())) lista2.add(p);
        }
        session.close();
        return lista2;
    }
    
    public String rezervisi(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Rezervacija novaRezervacija=new Rezervacija();
        novaRezervacija.setIdProjekcije(projekcija);
        Korisnik korisnik = (Korisnik) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("korisnik");
        novaRezervacija.setKorisnik(korisnik);
        novaRezervacija.setBrojUlaznica(brojUlaznicaZaProjekciju);
        vremeRezervacije=new Date();
        novaRezervacija.setVremeRezervacije(vremeRezervacije);
        kod=new String();
        for (int i = 0; i < 10; i++) {
            char c = (char) ((int) (Math.random() * 26) + 'A');
            kod+=c;
        }
        novaRezervacija.setKod(kod);
        session.save(novaRezervacija);
        session.getTransaction().commit();
        session.close();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Rezervacija uspešna",null));
        return null;
    }
    
    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String country; 
    private String city;  
    private Map<String,String> countries;
    private Map<String,String> cities;
     
    @PostConstruct
    public void init() {
        countries  = new HashMap<String, String>();
        countries.put("USA", "USA");
        countries.put("Germany", "Germany");
        countries.put("Brazil", "Brazil");
         
        Map<String,String> map = new HashMap<String, String>();
        map.put("New York", "New York");
        map.put("San Francisco", "San Francisco");
        map.put("Denver", "Denver");
        data.put("USA", map);
         
        map = new HashMap<String, String>();
        map.put("Berlin", "Berlin");
        map.put("Munich", "Munich");
        map.put("Frankfurt", "Frankfurt");
        data.put("Germany", map);
         
        map = new HashMap<String, String>();
        map.put("Sao Paolo", "Sao Paolo");
        map.put("Rio de Janerio", "Rio de Janerio");
        map.put("Salvador", "Salvador");
        data.put("Brazil", map);
    }
 
    public Map<String, Map<String, String>> getData() {
        return data;
    }
 
    public String getCountry() {
        return country;
    }
 
    public void setCountry(String country) {
        this.country = country;
        System.out.println("New country: "+country);
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
        System.out.println("New city: "+city);
    }
 
    public Map<String, String> getCountries() {
        return countries;
    }
 
    public Map<String, String> getCities() {
        return cities;
    }
 
    public void onCountryChange() {
        if(country !=null && !country.equals(""))
            cities = data.get(country);
        else
            cities = new HashMap<String, String>();
    }
     
    public void displayLocation() {
        FacesMessage msg;
        if(city != null && country != null)
            msg = new FacesMessage("Selected", city + " of " + country);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected."); 
             
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    private String hello = "Hello World";
    private String notSet = "not set";

    public void doAction(ActionEvent evt)
    {
        notSet = hello;
    }

    /**
     * @return the hello
     */
    public String getHello()
    {
        return hello;
    }

    /**
     * @return the notSet
     */
    public String getNotSet()
    {
        return notSet;
    }

    /**
     * @param hello
     *          the hello to set
     */
    public void setHello(String hello)
    {
        this.hello = hello;
    }

    /**
     * @param notSet
     *          the notSet to set
     */
    public void setNotSet(String notSet)
    {
        this.notSet = notSet;
    }
}
