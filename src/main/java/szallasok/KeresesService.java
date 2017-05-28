package szallasok;

import szallasok.model.Szallasok;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Stefyy on 2017.05.26..
 */

public class KeresesService {

    public static List<Szallasok> kereses(String country)
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Szallas");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Szallasok> query =
                manager.createQuery("SELECT sz FROM Szallasok sz where szallas_cime like :name ", Szallasok.class);
        query.setParameter("name", "%" +country +"%");

        List<Szallasok> results = query.getResultList();

        manager.close();
        factory.close();

        return results;

    }

    public static List<Szallasok> kereses2(String country, String tipus)
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Szallas");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Szallasok> query =
                manager.createQuery("SELECT sz FROM Szallasok sz where szallas_cime like :name AND szallas_tipusa like :tipus", Szallasok.class);
        query.setParameter("name", "%" +country +"%");
        query.setParameter("tipus",tipus);

        List<Szallasok> results = query.getResultList();

        manager.close();
        factory.close();

        return results;

    }

    public static List<Szallasok> kereses3(String country, String tipus, String kedvenc)
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Szallas");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Szallasok> query =
                manager.createQuery("SELECT sz FROM Szallasok sz where szallas_cime like :name AND szallas_tipusa like :tipus AND hazikedvenc like :hazikedvenc", Szallasok.class);
        query.setParameter("name", "%" +country +"%");
        query.setParameter("tipus",tipus);
        query.setParameter("hazikedvenc",kedvenc);

        List<Szallasok> results = query.getResultList();
        manager.close();
        factory.close();
        return results;

    }

    public static List<Szallasok> kereses4(String country,String kedvenc)
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Szallas");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Szallasok> query =
                manager.createQuery("SELECT sz FROM Szallasok sz where szallas_cime like :name AND hazikedvenc like :hazikedvenc", Szallasok.class);
        query.setParameter("name", "%" +country +"%");
        query.setParameter("hazikedvenc",kedvenc);

        List<Szallasok> results = query.getResultList();
        manager.close();
        factory.close();
        return results;

    }
    public static List<Szallasok> kereses5(String tipus, String kedvenc)
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Szallas");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Szallasok> query =
                manager.createQuery("SELECT sz FROM Szallasok sz where szallas_tipusa like :tipus AND hazikedvenc like :hazikedvenc", Szallasok.class);
        query.setParameter("tipus",tipus);
        query.setParameter("hazikedvenc",kedvenc);

        List<Szallasok> results = query.getResultList();
        manager.close();
        factory.close();
        return results;

    }

    public static List<Szallasok> kereses6(String tipus)
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Szallas");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Szallasok> query =
                manager.createQuery("SELECT sz FROM Szallasok sz where szallas_tipusa like :tipus", Szallasok.class);
        query.setParameter("tipus",tipus);


        List<Szallasok> results = query.getResultList();
        manager.close();
        factory.close();
        return results;

    }

    public static List<Szallasok> kereses7(String kedvenc)
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Szallas");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Szallasok> query =
                manager.createQuery("SELECT sz FROM Szallasok sz where hazikedvenc like :hazikedvenc", Szallasok.class);
        query.setParameter("hazikedvenc",kedvenc);

        List<Szallasok> results = query.getResultList();
        manager.close();
        factory.close();
        return results;

    }

}
