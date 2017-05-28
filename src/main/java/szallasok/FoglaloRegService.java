package szallasok;

import szallasok.model.Felhasznalok;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Stefyy on 2017.05.25..
 */
public class FoglaloRegService {

    public void regisztracio(String felhasznalo, String teljesnev, String jelszo, String jelszoujra){

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Szallas");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Felhasznalok felhasznalok = new Felhasznalok();
        felhasznalok.setFelhasznalonev(felhasznalo);
        felhasznalok.setTeljesnev(teljesnev);
        felhasznalok.setJelszo(jelszo);
        felhasznalok.setJelszoujra(jelszoujra);

        manager.persist(felhasznalok);
        manager.getTransaction().commit();


        manager.close();
        factory.close();
    }
}
