package szallasok;

import szallasok.model.Felhasznalok;

/**
 * Created by Stefyy on 2017.05.29..
 */
public class BelepettService {
    //visszaadja ki van epp bejelentkezve
    private static Felhasznalok belepett = new Felhasznalok();

    public static Felhasznalok getBelepett() {
        return belepett;
    }

    public static void setBelepett(Felhasznalok belepett) {
        BelepettService.belepett = belepett;
    }
}
