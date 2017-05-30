package szallasok;

import szallasok.model.Foglalasok;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

/**
 * Created by Stefyy on 2017.05.29..
 */
public class FoglalasService {

    public void szallasFoglalas(String nev, String szallasnev, String szobaszam, LocalDate erkezes,
                                LocalDate tavozas, int ejszakakszama, int erkezok, int fizetendo){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Szallas");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Foglalasok foglalas = new Foglalasok();
        foglalas.setFoglalo_neve(nev);
        foglalas.setSzallas_neve(szallasnev);
        foglalas.setSzoba_szama(szobaszam);
        foglalas.setErkezes_idopontja(erkezes);
        foglalas.setTavozas_idopontja(tavozas);
        foglalas.setEjszakak_szama(ejszakakszama);
        foglalas.setErkezok_szama(erkezok);
        foglalas.setFizetendo(fizetendo);

        manager.persist(foglalas);
        manager.getTransaction().commit();


        manager.close();
        factory.close();
    }

}
