package szallasok;

import szallasok.model.Szallasok;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Stefyy on 2017.05.21..
 */
public class SzallasFelvetelService {

    public void szallasLetrehozas(String nev, String cim, String tipus, String haziallat, String leiras,
                                  int egyes_egyszemelyes, int egyes_ketszemelyes, int egyes_ferohely, int egyes_ado, int egyes_ar,
                                  int kettes_egyszemelyes, int kettes_ketszemelyes, int kettes_ferohely, int kettes_ado, int kettes_ar,
                                  int harmas_egyszemelyes, int harmas_ketszemelyes, int harmas_ferohely, int harmas_ado, int harmas_ar){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Szallas");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Szallasok felvetel = new Szallasok();
        felvetel.setSzallas_neve(nev);
        felvetel.setSzallas_cime(cim);
        felvetel.setSzallas_tipusa(tipus);
        felvetel.setHazikedvenc(haziallat);
        felvetel.setLeiras(leiras);
        felvetel.setEgyes_szoba_egyszemelyes_agy(egyes_egyszemelyes);
        felvetel.setEgyes_szoba_ketszemelyes_agy(egyes_ketszemelyes);
        felvetel.setEgyes_szoba_ferohely(egyes_ferohely);
        felvetel.setEgyes_szoba_ado(egyes_ado);
        felvetel.setEgyes_szoba_ar(egyes_ar);
        felvetel.setKettes_szoba_egyszemelyes_agy(kettes_egyszemelyes);
        felvetel.setKettes_szoba_ketszemelyes_agy(kettes_ketszemelyes);
        felvetel.setKettes_szoba_ferohely(kettes_ferohely);
        felvetel.setKettes_szoba_ado(kettes_ado);
        felvetel.setKettes_szoba_ar(kettes_ar);
        felvetel.setHarmas_szoba_egyszemelyes_agy(harmas_egyszemelyes);
        felvetel.setHarmas_szoba_ketszemelyes_agy(harmas_ketszemelyes);
        felvetel.setHarmas_szoba_ferohely(harmas_ferohely);
        felvetel.setHarmas_szoba_ado(harmas_ado);
        felvetel.setHarmas_szoba_ar(harmas_ar);
        manager.persist(felvetel);
        manager.getTransaction().commit();


        manager.close();
        factory.close();
    }




}
