package szallasok;

import szallasok.model.Felhasznalok;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Stefyy on 2017.05.28..
 */
public class BelepesService {

    public static List<Felhasznalok> felhasznaloLista()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Szallas");
        EntityManager manager = factory.createEntityManager();

        TypedQuery<Felhasznalok> query =
                manager.createQuery("SELECT f FROM Felhasznalok f", Felhasznalok.class);
        List<Felhasznalok> results = query.getResultList();
        return results;

    }
}
