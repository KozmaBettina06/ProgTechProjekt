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

    public static List<String> felhasznaloLista()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Szallas");
        EntityManager manager = factory.createEntityManager();

        TypedQuery<String> query =
                manager.createQuery("SELECT f.felhasznalonev FROM Felhasznalok f", String.class);
        List<String> results = query.getResultList();
        manager.close();
        factory.close();
        return results;

    }

    public static String jelszoLista(String felhasznalonev)
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Szallas");
        EntityManager manager = factory.createEntityManager();

        TypedQuery<String> query =
                manager.createQuery("SELECT f.jelszo FROM Felhasznalok f where felhasznalonev like :name", String.class);
        query.setParameter("name",felhasznalonev);
        String results = query.getSingleResult();
        manager.close();
        factory.close();
        return results;

    }
}
