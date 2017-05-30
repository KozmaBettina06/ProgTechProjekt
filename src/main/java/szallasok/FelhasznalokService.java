package szallasok;

import szallasok.model.Felhasznalok;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Stefyy on 2017.05.30..
 */
public class FelhasznalokService {
    public Felhasznalok felhasznalokereso(String nev){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Szallas");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Felhasznalok> query =
                manager.createQuery("SELECT f FROM Felhasznalok f where felhasznalonev like :name",Felhasznalok.class);
        query.setParameter("name", nev);
        Felhasznalok belepettFelhasznalo = query.getSingleResult();
        manager.close();
        factory.close();
        return belepettFelhasznalo;
    }
}
