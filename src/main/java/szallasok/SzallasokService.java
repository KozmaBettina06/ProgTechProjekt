package szallasok;

import szallasok.model.Szallasok;

/**
 * Created by Stefyy on 2017.05.30..
 */
public class SzallasokService {
    //visszaadja melyik szallas van kivalasztva a kereseskor
    private static Szallasok valasztottSzallas = new Szallasok();

    public static Szallasok getValasztottSzallas() {
        return valasztottSzallas;
    }

    public static void setValasztottSzallas(Szallasok valasztottSzallas) {
        SzallasokService.valasztottSzallas = valasztottSzallas;
    }
}
