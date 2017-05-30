package szallasok.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by Stefyy on 2017.05.29..
 */
@Entity
public class Foglalasok {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String foglalo_neve;
    private String szallas_neve;
    private String szoba_szama;
    private LocalDate erkezes_idopontja;
    private LocalDate tavozas_idopontja;
    private int ejszakak_szama;
    private int erkezok_szama;
    private int fizetendo;

    public Foglalasok() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoglalo_neve() {
        return foglalo_neve;
    }

    public void setFoglalo_neve(String foglalo_neve) {
        this.foglalo_neve = foglalo_neve;
    }

    public String getSzallas_neve() {
        return szallas_neve;
    }

    public void setSzallas_neve(String szallas_neve) {
        this.szallas_neve = szallas_neve;
    }

    public String getSzoba_szama() {
        return szoba_szama;
    }

    public void setSzoba_szama(String szoba_szama) {
        this.szoba_szama = szoba_szama;
    }

    public LocalDate getErkezes_idopontja() {
        return erkezes_idopontja;
    }

    public void setErkezes_idopontja(LocalDate erkezes_idopontja) {
        this.erkezes_idopontja = erkezes_idopontja;
    }

    public LocalDate getTavozas_idopontja() {
        return tavozas_idopontja;
    }

    public void setTavozas_idopontja(LocalDate tavozas_idopontja) {
        this.tavozas_idopontja = tavozas_idopontja;
    }

    public int getEjszakak_szama() {
        return ejszakak_szama;
    }

    public void setEjszakak_szama(int ejszakak_szama) {
        this.ejszakak_szama = ejszakak_szama;
    }

    public int getErkezok_szama() {
        return erkezok_szama;
    }

    public void setErkezok_szama(int erkezok_szama) {
        this.erkezok_szama = erkezok_szama;
    }

    public int getFizetendo() {
        return fizetendo;
    }

    public void setFizetendo(int fizetendo) {
        this.fizetendo = fizetendo;
    }
}
