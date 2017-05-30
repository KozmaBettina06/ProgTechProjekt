package szallasok;

import szallasok.model.Foglalasok;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Stefyy on 2017.05.30..
 */
public class FoglaltFigyeloService {

    public List<Foglalasok> foglaltkereso(String szallasnev) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Szallas");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Foglalasok> query =
                manager.createQuery("SELECT fog FROM Foglalasok fog where szallas_neve like :name", Foglalasok.class);
        query.setParameter("name", szallasnev);

        List<Foglalasok> foglalasok = query.getResultList();
        manager.close();
        factory.close();
        return foglalasok;
    }
}
