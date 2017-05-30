package szallasok;

import szallasok.model.Szallasok;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Created by Stefyy on 2017.05.30..
 */
public class KivalasztottSzallasService {
    public Szallasok szallaskereso(String szallasNev){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Szallas");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Szallasok> query =
                manager.createQuery("SELECT sz FROM Szallasok sz where szallas_neve like :name ", Szallasok.class);
        query.setParameter("name", szallasNev);
        Szallasok szallasok = query.getSingleResult();

        manager.close();
        factory.close();
        return szallasok;

    }
}
