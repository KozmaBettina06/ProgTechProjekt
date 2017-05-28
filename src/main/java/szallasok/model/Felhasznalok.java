package szallasok.model;
import javax.persistence.*;

/**
 * Created by Stefyy on 2017.05.25..
 */
@Entity
public class Felhasznalok {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String felhasznalonev;
    private String teljesnev;
    private String jelszo;
    private String jelszoujra;

    public Felhasznalok(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    public String getTeljesnev() {
        return teljesnev;
    }

    public void setTeljesnev(String teljesnev) {
        this.teljesnev = teljesnev;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public String getJelszoujra() {
        return jelszoujra;
    }

    public void setJelszoujra(String jelszoujra) {
        this.jelszoujra = jelszoujra;
    }
}
