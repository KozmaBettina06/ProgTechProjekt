package szallasok.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Stefyy on 2017.05.20..
 */

@Entity
public class Szallasok {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String Szallas_neve;
    private String szallas_cime;
    private String Szallas_tipusa;
    private String Hazikedvenc;
    private String Leiras;
    private int egyes_szoba_egyszemelyes_agy;
    private int egyes_szoba_ketszemelyes_agy;
    private int egyes_szoba_ferohely;
    private int egyes_szoba_ado;
    private int egyes_szoba_ar;

    private int kettes_szoba_egyszemelyes_agy;
    private int kettes_szoba_ketszemelyes_agy;
    private int kettes_szoba_ferohely;
    private int kettes_szoba_ado;
    private int kettes_szoba_ar;

    private int harmas_szoba_egyszemelyes_agy;
    private int harmas_szoba_ketszemelyes_agy;
    private int harmas_szoba_ferohely;
    private int harmas_szoba_ado;
    private int harmas_szoba_ar;


    public Szallasok() {

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSzallas_neve() {
        return Szallas_neve;
    }

    public void setSzallas_neve(String szallas_neve) {
        Szallas_neve = szallas_neve;
    }

    public String getSzallas_cime() {
        return szallas_cime;
    }

    public void setSzallas_cime(String szallas_cime) {
        this.szallas_cime = szallas_cime;
    }

    public String getSzallas_tipusa() {
        return Szallas_tipusa;
    }

    public void setSzallas_tipusa(String szallas_tipusa) {
        Szallas_tipusa = szallas_tipusa;
    }

    public String getHazikedvenc() {
        return Hazikedvenc;
    }

    public void setHazikedvenc(String hazikedvenc) {
        Hazikedvenc = hazikedvenc;
    }

    public String getLeiras() {
        return Leiras;
    }

    public void setLeiras(String leiras) {
        Leiras = leiras;
    }

    public int getEgyes_szoba_egyszemelyes_agy() {
        return egyes_szoba_egyszemelyes_agy;
    }

    public void setEgyes_szoba_egyszemelyes_agy(int egyes_szoba_egyszemelyes_agy) {
        this.egyes_szoba_egyszemelyes_agy = egyes_szoba_egyszemelyes_agy;
    }

    public int getEgyes_szoba_ketszemelyes_agy() {
        return egyes_szoba_ketszemelyes_agy;
    }

    public void setEgyes_szoba_ketszemelyes_agy(int egyes_szoba_ketszemelyes_agy) {
        this.egyes_szoba_ketszemelyes_agy = egyes_szoba_ketszemelyes_agy;
    }

    public int getEgyes_szoba_ferohely() {
        return egyes_szoba_ferohely;
    }

    public void setEgyes_szoba_ferohely(int egyes_szoba_ferohely) {
        this.egyes_szoba_ferohely = egyes_szoba_ferohely;
    }

    public int getEgyes_szoba_ado() {
        return egyes_szoba_ado;
    }

    public void setEgyes_szoba_ado(int egyes_szoba_ado) {
        this.egyes_szoba_ado = egyes_szoba_ado;
    }

    public int getEgyes_szoba_ar() {
        return egyes_szoba_ar;
    }

    public void setEgyes_szoba_ar(int egyes_szoba_ar) {
        this.egyes_szoba_ar = egyes_szoba_ar;
    }



    public int getKettes_szoba_egyszemelyes_agy() {
        return kettes_szoba_egyszemelyes_agy;
    }

    public void setKettes_szoba_egyszemelyes_agy(int kettes_szoba_egyszemelyes_agy) {
        this.kettes_szoba_egyszemelyes_agy = kettes_szoba_egyszemelyes_agy;
    }

    public int getKettes_szoba_ketszemelyes_agy() {
        return kettes_szoba_ketszemelyes_agy;
    }

    public void setKettes_szoba_ketszemelyes_agy(int kettes_szoba_ketszemelyes_agy) {
        this.kettes_szoba_ketszemelyes_agy = kettes_szoba_ketszemelyes_agy;
    }

    public int getKettes_szoba_ferohely() {
        return kettes_szoba_ferohely;
    }

    public void setKettes_szoba_ferohely(int kettes_szoba_ferohely) {
        this.kettes_szoba_ferohely = kettes_szoba_ferohely;
    }

    public int getKettes_szoba_ado() {
        return kettes_szoba_ado;
    }

    public void setKettes_szoba_ado(int kettes_szoba_ado) {
        this.kettes_szoba_ado = kettes_szoba_ado;
    }

    public int getKettes_szoba_ar() {
        return kettes_szoba_ar;
    }

    public void setKettes_szoba_ar(int kettes_szoba_ar) {
        this.kettes_szoba_ar = kettes_szoba_ar;
    }



    public int getHarmas_szoba_egyszemelyes_agy() {
        return harmas_szoba_egyszemelyes_agy;
    }

    public void setHarmas_szoba_egyszemelyes_agy(int harmas_szoba_egyszemelyes_agy) {
        this.harmas_szoba_egyszemelyes_agy = harmas_szoba_egyszemelyes_agy;
    }

    public int getHarmas_szoba_ketszemelyes_agy() {
        return harmas_szoba_ketszemelyes_agy;
    }

    public void setHarmas_szoba_ketszemelyes_agy(int harmas_szoba_ketszemelyes_agy) {
        this.harmas_szoba_ketszemelyes_agy = harmas_szoba_ketszemelyes_agy;
    }

    public int getHarmas_szoba_ferohely() {
        return harmas_szoba_ferohely;
    }

    public void setHarmas_szoba_ferohely(int harmas_szoba_ferohely) {
        this.harmas_szoba_ferohely = harmas_szoba_ferohely;
    }

    public int getHarmas_szoba_ado() {
        return harmas_szoba_ado;
    }

    public void setHarmas_szoba_ado(int harmas_szoba_ado) {
        this.harmas_szoba_ado = harmas_szoba_ado;
    }

    public int getHarmas_szoba_ar() {
        return harmas_szoba_ar;
    }

    public void setHarmas_szoba_ar(int harmas_szoba_ar) {
        this.harmas_szoba_ar = harmas_szoba_ar;
    }

    @Transient
    private boolean egyes=false;
    @Transient
    private boolean kettes=false;
    @Transient
    private boolean harmas=false;
    @Transient
    private LocalDate erkezes;

    @Transient
    private LocalDate tavozas;
    @Transient
    public LocalDate getErkezes() {
        return erkezes;
    }
    @Transient
    public void setErkezes(LocalDate erkezes) {
        this.erkezes = erkezes;
    }
    @Transient
    public LocalDate getTavozas() {
        return tavozas;
    }
    @Transient
    public void setTavozas(LocalDate tavozas) {
        this.tavozas = tavozas;
    }
    @Transient
    private int ferohely=0;

    @Transient
    public int getFerohely() {
        return ferohely;
    }

    public void setFerohely(int ferohely) {
        this.ferohely = ferohely;
    }

    @Transient
    public boolean isEgyes() {
        return egyes;
    }
    @Transient
    public void setEgyes(boolean egyes) {
        this.egyes = egyes;
    }
    @Transient
    public boolean isKettes() {
        return kettes;
    }
    @Transient
    public void setKettes(boolean kettes) {
        this.kettes = kettes;
    }
    @Transient
    public boolean isHarmas() {
        return harmas;
    }
    @Transient
    public void setHarmas(boolean harmas) {
        this.harmas = harmas;
    }

    @Transient
    @Override
    public String toString() {
        return "Szallasok{" +
                "id=" + id +
                ", Szallas_neve='" + Szallas_neve + '\'' +
                ", szallas_cime='" + szallas_cime + '\'' +
                ", Szallas_tipusa='" + Szallas_tipusa + '\'' +
                ", Hazikedvenc='" + Hazikedvenc + '\'' +
                ", Leiras='" + Leiras + '\'' +
                ", egyes_szoba_egyszemelyes_agy=" + egyes_szoba_egyszemelyes_agy +
                ", egyes_szoba_ketszemelyes_agy=" + egyes_szoba_ketszemelyes_agy +
                ", egyes_szoba_ferohely=" + egyes_szoba_ferohely +
                ", egyes_szoba_ado=" + egyes_szoba_ado +
                ", egyes_szoba_ar=" + egyes_szoba_ar +
                ", kettes_szoba_egyszemelyes_agy=" + kettes_szoba_egyszemelyes_agy +
                ", kettes_szoba_ketszemelyes_agy=" + kettes_szoba_ketszemelyes_agy +
                ", kettes_szoba_ferohely=" + kettes_szoba_ferohely +
                ", kettes_szoba_ado=" + kettes_szoba_ado +
                ", kettes_szoba_ar=" + kettes_szoba_ar +
                ", harmas_szoba_egyszemelyes_agy=" + harmas_szoba_egyszemelyes_agy +
                ", harmas_szoba_ketszemelyes_agy=" + harmas_szoba_ketszemelyes_agy +
                ", harmas_szoba_ferohely=" + harmas_szoba_ferohely +
                ", harmas_szoba_ado=" + harmas_szoba_ado +
                ", harmas_szoba_ar=" + harmas_szoba_ar +
                '}';
    }
}
